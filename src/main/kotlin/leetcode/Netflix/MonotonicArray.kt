package leetcode.Netflix

fun isMonotonic(arr: IntArray?): Boolean {

    var isIncreasing = true
    var isDecreasing = true

    for (i in 0 until arr?.size!! - 1) {
        if (arr[i] < arr[i+1]) isDecreasing = false
        if (arr[i] > arr[i+1]) isIncreasing = false
    }
    return isIncreasing || isDecreasing
}
fun main() {
    val arr = intArrayOf(1, 2, 3, 3, 3, 3, 3, 3, 5, 5, 5, 5, 9)
    println(isMonotonic(arr))
}