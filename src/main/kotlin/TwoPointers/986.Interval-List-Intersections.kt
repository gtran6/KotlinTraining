package TwoPointers

fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
    val res = mutableListOf<IntArray>()
    var i = 0
    var j = 0

    while (i < firstList.size && j < secondList.size) {
        val low = maxOf(firstList[i][0], secondList[j][0])
        val high = minOf(firstList[i][1], secondList[j][1])

        if (low <= high) {
            res.add(intArrayOf(low, high))
        }
        // Move to the next interval with the smallest end value
        if (firstList[i][1] < secondList[j][1]) {
            i++
        } else {
            j++
        }
    }
    return res.toTypedArray()
}
fun main() {
    val firstList = arrayOf(intArrayOf(1, 3), intArrayOf(5, 9))
    val secondList = arrayOf(intArrayOf(2, 4), intArrayOf(6, 8))
    println(intervalIntersection(firstList, secondList).contentDeepToString())
}