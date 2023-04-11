package MergeIntervals

fun merge(intervals: Array<IntArray>): Array<IntArray> {

    if (intervals.isEmpty()) return emptyArray()

    intervals.sortBy { it.first() }

    val result = mutableListOf<IntArray>()
    var prevInterval = intervals[0]

    /*
    Loop through the sorted intervals:
    a. If the current interval overlaps with the previous interval, merge them into a new interval that covers the entire range.
    b. If there is no overlap, add the previous interval to the result array.
     */
    for (i in 1 until intervals.size) {
        val currInterval = intervals[i]

        if (currInterval[0] <= prevInterval[1]) {
            prevInterval[1] = maxOf(prevInterval[1], currInterval[1])
        } else {
            result.add(prevInterval)
            prevInterval = currInterval
        }
    }

    //Add the last interval to the result array.
    result.add(prevInterval)
    return result.toTypedArray()
}
fun main() {
    val intervals = arrayOf(intArrayOf(1,3), intArrayOf(2,6), intArrayOf(8,10), intArrayOf(15,18))
    println(merge(intervals).contentDeepToString())
}