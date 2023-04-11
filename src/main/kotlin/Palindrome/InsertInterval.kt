package Palindrome

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    var i = 0

    /*
    The first while loop adds intervals that come before the new interval to the mergedIntervals list.
    It checks whether the end time of the current interval is less than the start time of the new interval,
    and if so, adds the current interval to mergedIntervals and increments i.
     */
    while (i < intervals.size && intervals[i][1] < newInterval[0]) {
        result.add(intervals[i])
        i++
    }

    /*
    The second while loop merges overlapping intervals with the new interval. It checks whether the
    start time of the current interval is less than or equal to the end time of the new interval.
    If so, it updates the start and end times of the new interval to include the current interval, and increments i.
     */
    while (i < intervals.size && intervals[i][0] <= newInterval[1]) {
        newInterval[0] = minOf(newInterval[0], intervals[i][0])
        newInterval[1] = maxOf(newInterval[1], intervals[i][1])
        i++
    }

    //Once all overlapping intervals have been merged, the new interval is added to the mergedIntervals list.
    result.add(newInterval)

    //The final while loop adds any remaining intervals that come after the new interval to the mergedIntervals list.
    while (i < intervals.size) {
        result.add(intervals[i])
        i++
    }
    return result.toTypedArray()
}
fun main() {
    val intervals = arrayOf(intArrayOf(1,3), intArrayOf(6,9))
    val newInterval = intArrayOf(2,5)
    println(insert(intervals, newInterval).contentDeepToString())
}