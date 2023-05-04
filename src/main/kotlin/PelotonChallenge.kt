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

    val zoneDurations = IntArray(4)

    var prevTime = 0
    var prevBpm = timesAndBeats[0].second

    for (i in 1 until timesAndBeats.size) {
        val time = timesAndBeats[i].first
        val bpm = timesAndBeats[i].second

        val interval = time - prevTime
        val prevZone = heartRateZones.lastOrNull { bpm >= it.first } ?: heartRateZones.first()

        val zoneIndex = heartRateZones.indexOf(prevZone)
        if (zoneIndex >= 0) {
            zoneDurations[zoneIndex] += interval
        }

        prevTime = time
        prevBpm = bpm
    }

    val finalInterval = duration - prevTime
    val finalZone = heartRateZones.lastOrNull { prevBpm >= it.first } ?: heartRateZones.first()

    val finalZoneIndex = heartRateZones.indexOf(finalZone)
    if (finalZoneIndex >= 0) {
        zoneDurations[finalZoneIndex] += finalInterval
    }

    return zoneDurations.toTypedArray().reversedArray()
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