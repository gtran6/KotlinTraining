fun timeInHeartRateZonesForWorkout(workout: Array<Pair<Int, Int>>, maxHeartRate: Int): List<Int> {
    val zones = listOf(
        0 to 60,
        60 to 75,
        75 to 85,
        85 to 100
    )
    val timeInZones = MutableList(zones.size) { 0 }

    for (i in 1 until workout.size) {
        val (prevTime, prevBpm) = workout[i - 1]
        val (currTime, currBpm) = workout[i]
        val elapsedTime = currTime - prevTime
        val avgBpm = (prevBpm + currBpm) / 2.0
        val percentMax = (avgBpm / maxHeartRate) * 100.0

        for (j in zones.indices) {
            val (minPercent, maxPercent) = zones[j]
            if (percentMax >= minPercent && percentMax < maxPercent) {
                timeInZones[j] += elapsedTime
                break
            }
        }
    }
    return timeInZones.reversed()
}

fun main() {
    val workout = arrayOf(
        0 to 70,
        50 to 90,
        60 to 120,
        70 to 135,
        100 to 150,
        300 to 180,
        400 to 75
    )
    val maxHeartRate = 185
    val result = timeInHeartRateZonesForWorkout(workout, maxHeartRate)
    println(result.toList())
}
// [100,200,40,160]