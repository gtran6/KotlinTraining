package MergeIntervals

fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
    intervals.sortBy { it[1] }
    var count = 0
    var end = Int.MIN_VALUE
    for (interval in intervals) {
        if (interval[0] >= end) {
            end = interval[1]
            count++
        }
    }
    return intervals.size - count
}
fun main() {
    val intervals = arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4), intArrayOf(1,3))
    println(eraseOverlapIntervals(intervals))
}
/*
This function first sorts the intervals by their end times using the sortBy function.
Then, it initializes the count and end variables to 0 and Int.MIN_VALUE, respectively.
It then loops through each interval and checks if the start time of the current interval is greater than or equal to end.
If it is, it sets end to the end time of the current interval and increments count.
If the start time is less than end, it skips this interval as it overlaps with a previous interval.
Finally, it returns the total number of overlapping intervals minus count.
 */