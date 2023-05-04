fun timeInHeartRateZonesForWorkout(
    timesAndBeats: Array<Pair<Int, Int>>,
    maxHeartRate: Int,
    duration: Int
): Array<Int> {
    val heartRateZones = listOf(
        Pair((0.0 * maxHeartRate).toInt(), (0.6 * maxHeartRate).toInt()),
        Pair((0.6 * maxHeartRate).toInt(), (0.75 * maxHeartRate).toInt()),
        Pair((0.75 * maxHeartRate).toInt(), (0.85 * maxHeartRate).toInt()),
        Pair((0.85 * maxHeartRate).toInt(), (1.0 * maxHeartRate).toInt())
    )

    var peakTime = 0
    var cardioTime = 0
    var fatburnTime = 0
    var warmupTime = 0

    var prevTime = 0
    var prevBpm = timesAndBeats[0].second

    for (i in 1 until timesAndBeats.size) {
        val time = timesAndBeats[i].first
        val bpm = timesAndBeats[i].second

        val interval = time - prevTime
        val prevZone = heartRateZones.lastOrNull { bpm >= it.first } ?: heartRateZones.first()

        when (prevZone) {
            heartRateZones[0] -> warmupTime += interval
            heartRateZones[1] -> fatburnTime += interval
            heartRateZones[2] -> cardioTime += interval
            heartRateZones[3] -> peakTime += interval
        }

        prevTime = time
        prevBpm = bpm
    }

    val finalInterval = duration - prevTime
    val finalZone = heartRateZones.lastOrNull { prevBpm >= it.first } ?: heartRateZones.first()

    when (finalZone) {
        heartRateZones[0] -> warmupTime += finalInterval
        heartRateZones[1] -> fatburnTime += finalInterval
        heartRateZones[2] -> cardioTime += finalInterval
        heartRateZones[3] -> peakTime += finalInterval
    }

    return arrayOf(peakTime, cardioTime, fatburnTime, warmupTime)
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