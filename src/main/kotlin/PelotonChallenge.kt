fun timeInHeartRateZonesForWorkout(pairs: Array<Pair<Int, Int>>, maxHeartRate: Int, workoutDuration: Int): Array<Int> {
    // Calculate heart rate zones
    val zones = listOf(
        Pair((0.0 * maxHeartRate).toInt(), (0.6 * maxHeartRate).toInt()),
        Pair((0.6 * maxHeartRate).toInt(), (0.75 * maxHeartRate).toInt()),
        Pair((0.75 * maxHeartRate).toInt(), (0.85 * maxHeartRate).toInt()),
        Pair((0.85 * maxHeartRate).toInt(), (1.0 * maxHeartRate).toInt())
    )

    // Initialize time spent in each zone to 0
    val timeInZones = Array(4) { 0 }

    // Calculate time spent in each zone
    for (i in 1 until pairs.size) {
        val timeInZone = pairs[i].first - pairs[i - 1].first
        val avgHeartRate = (pairs[i].second + pairs[i - 1].second) / 2

        for (j in zones.indices) {
            if (avgHeartRate > zones[j].first && avgHeartRate <= zones[j].second) {
                timeInZones[j] += timeInZone
                break
            }
        }
    }

    // Calculate time spent in warm up zone
    timeInZones[3] += workoutDuration - pairs[pairs.size - 1].first

    return timeInZones
}

fun main() {
    val timesAndBeats = arrayOf(
        Pair(0, 70),
        Pair(50, 90),
        Pair(60, 120),
        Pair(70, 135),
        Pair(100, 150),
        Pair(300, 180),
        Pair(400, 75)
    )
    val maxHeartRate = 185
    val duration = 500
    println(timeInHeartRateZonesForWorkout(timesAndBeats, maxHeartRate, duration).contentDeepToString())
}
// [100,200,40,160]