package intervals

fun findRightInterval(intervals: Array<IntArray>): IntArray {
    val n = intervals.size
    val sortedIntervals = intervals.withIndex().sortedBy { it.value[0] }

    val res = IntArray(n)
    for (i in 0 until n) {
        val end = sortedIntervals[i].value[1]
        var left = i + 1
        var right = n - 1
        var ans = -1
        while (left <= right) {
            val mid = (left + right) / 2
            if (sortedIntervals[mid].value[0] >= end) {
                ans = sortedIntervals[mid].index
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        res[sortedIntervals[i].index] = ans
    }
    return res
}
fun main() {
    val intervals = arrayOf(intArrayOf(1,4), intArrayOf(2,3), intArrayOf(3,4))
    val intervals1 = arrayOf(intArrayOf(1,1), intArrayOf(3,4))
    println(findRightInterval(intervals).contentToString())
}