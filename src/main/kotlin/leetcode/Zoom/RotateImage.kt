package leetcode.Zoom

fun autoRotate1(matrix: Array<IntArray>): Unit {
    val n = matrix.size
    //val result = Array(n) {IntArray(n)}
    // edges of the 2D array matrix
    var left = 0
    var right = n-1
    var top = 0
    var bottom = n-1
    while (left < right && top < bottom) {
        for (i in left until right) {
            val offset = i -left
            val tmp = matrix[top][i]
            matrix[top][i] = matrix[bottom-offset][left]
            matrix[bottom-offset][left] = matrix[bottom][right-offset]
            matrix[bottom][right-offset] = matrix[top+offset][right]
            matrix[top+offset][right] = tmp
        }
        left++
        right--
        top++
        bottom--
    }
    //return result
}
fun main() {
    val matrix = arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(4,5,6),
        intArrayOf(7,8,9))
    println(autoRotate1(matrix))
}