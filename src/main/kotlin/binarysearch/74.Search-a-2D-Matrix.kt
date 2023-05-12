package binarysearch

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val rows = matrix.size
    val cols = matrix[0].size
    var left = 0
    var right = rows*cols - 1

    while (left <= right) {
        val mid = left + (right - left)/2
        val row = mid / cols // This formula gives us the row index of the middle element
        val col = mid % cols // This formula gives us the column index of the middle element
        val value = matrix[row][col]

        if (value == target) return true
        else if (value < target) left = mid + 1
        else right = mid - 1
    }
    return false
}
fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 3, 5, 7),
        intArrayOf(10, 11, 16, 20),
        intArrayOf(23, 30, 34, 60)
    )
    val target = 4
    println(searchMatrix(matrix, target))
}