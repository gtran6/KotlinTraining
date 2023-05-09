package dfs

import kotlin.math.min

fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
    val rows = mat.size
    val cols = mat[0].size

    val distance = Array(rows) { IntArray(cols) { Int.MAX_VALUE } }

    // Initialize distances for cells with value 0
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (mat[i][j] == 0) {
                distance[i][j] = 0
            }
        }
    }

    // Compute distances from cells with value 0 to other cells
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (mat[i][j] == 0) {
                continue
            }
            if (i > 0) {
                distance[i][j] = min(distance[i][j], distance[i-1][j] + 1)
            }
            if (j > 0) {
                distance[i][j] = min(distance[i][j], distance[i][j-1] + 1)
            }
        }
    }

    // Compute distances from cells with value 0 to other cells (in reverse order)
    for (i in rows - 1 downTo 0) {
        for (j in cols - 1 downTo 0) {
            if (mat[i][j] == 0) {
                continue
            }
            if (i < rows - 1) {
                distance[i][j] = min(distance[i][j], distance[i+1][j] + 1)
            }
            if (j < cols - 1) {
                distance[i][j] = min(distance[i][j], distance[i][j+1] + 1)
            }
        }
    }
    return distance
}
fun main() {
    val mat = arrayOf(intArrayOf(0,0,0), intArrayOf(0,1,0), intArrayOf(1,1,1))
    println(updateMatrix(mat).contentDeepToString())
}