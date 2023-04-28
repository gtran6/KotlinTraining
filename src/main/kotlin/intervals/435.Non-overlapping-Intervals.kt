package intervals

fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
    intervals.sortBy { it[1] }
    var count = 0
    var j = 0
    for (i in 1 until intervals.size) {
        var nextStartIndex = intervals[i][0]
        var nextEndIndex = intervals[i][1]
        var currentEndIndex = intervals[j][1]

        if (currentEndIndex > nextStartIndex) {
            count++
            if (nextEndIndex < currentEndIndex) {
                j = i
            }
        } else {
            j = i
        }
    }
    return count
}
fun main() {
    val intervals = arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4), intArrayOf(1,3))
    println(eraseOverlapIntervals(intervals))
}
/*
- first case : [2,4], [5,8]
The first case is the easiest, which is when there is non-overlapping between the two intervals.
In this case, we only need to move the previous pointer (j) to the next pointer(i), and the count
of intervals removed remains unchanged.

- second case : [5,8], [7,9]
The current endpoint is 8, and the next starting point is 7, which we know the intervals overlapping
one another. The greedy approach is that we can remove the later interval, which is the [7,9] interval.

- third case : [1,100], [1,11], [11,30]
Since we want to find the minimum number of intervals, we need to remove them to make the rest
of the intervals non-overlapping; therefore, removing interval [1,100] is a better choice.
 */