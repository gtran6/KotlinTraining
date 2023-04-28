package intervals

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    intervals.sortBy { it[0] }
    val res = mutableListOf<IntArray>()

    for (interval in intervals) {
        //checks if the result list is empty (in which case the new interval is added to it)
        if (res.isEmpty() || res.last()[1] < interval[0]) {
            res.add(interval)
        } else {
            res.last()[1] = maxOf(res.last()[1], interval[1])
        }
    }
    return res.toTypedArray()
}
fun main() {
    val intervals = arrayOf(intArrayOf(1,3), intArrayOf(2,6), intArrayOf(8,10), intArrayOf(15,18))
    println(merge(intervals).contentDeepToString())
}
/*
Insert the first interval from the input list into the output list.

Traverse the input list of intervals. For each interval in the input list, we do the following:

If the input interval is overlapping with the last interval in the output list, merge these two intervals
and replace the last interval of the output list with this merged interval.
Otherwise, add the input interval to the output list.
 */