package leetcode.Zoom

fun autoRotate(matrix: Array<IntArray>) {
    var left = 0
    var right = matrix.size-1

    while (left < right) {
        // `right - left` moves our square in by 1 each outer iteration
        // the index is used to rotate the coordinates
        for (i in 0 until right - left) {
            val top = left
            val bottom = right
            val topLeft = matrix[top][left+i]

            // move bottomLeft to topLeft
            matrix[top][left+i] = matrix[bottom-i][left]
            // move bottomRight to bottomLeft
            matrix[bottom-i][left] = matrix[bottom][right-i]
            // move topRight to bottomRight
            matrix[bottom][right-i] = matrix[top+i][right]
            // set saved to topRight
            matrix[top+i][right] = topLeft

        }
        left++
        right--
    }
    println(printMatrix(matrix))
}

fun printMatrix(matrix: Array<IntArray>): Any {
    var str = "["
    for (i in matrix.indices) {
        str += "["
        for (j in 0 until matrix[i].size) {
            str += matrix[i][j].toString()
            if (j + 1 < matrix[i].size) {
                str += " "
            }
        }
        str += if (i == matrix.size - 1) {
            "]"
        } else {
            "]\n"
        }
        if (i + 1 < matrix.size) {
            str += " "
        }
    }
    str += "]"
    return str
}
fun main() {
    val matrix = arrayOf(
        intArrayOf(5, 1, 9, 11),
        intArrayOf(2, 4, 8, 10),
        intArrayOf(13, 3, 6, 7),
        intArrayOf(15, 14, 12, 16)
    )
    println(autoRotate(matrix))
}
