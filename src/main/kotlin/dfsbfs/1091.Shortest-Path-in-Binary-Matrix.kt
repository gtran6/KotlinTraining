package dfsbfs

import java.util.*

fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
    val n = grid.size
    val directions = arrayOf(
        intArrayOf(-1, -1), intArrayOf(-1, 0), intArrayOf(-1, 1),
        intArrayOf(0, -1), /* current position */ intArrayOf(0, 1),
        intArrayOf(1, -1), intArrayOf(1, 0), intArrayOf(1, 1)
    )

    // Check if the given cell coordinates are valid
    fun isValidCell(row: Int, col: Int): Boolean {
        return row in 0 until n && col in 0 until n
    }

    // Check if the given cell is a valid destination
    fun isDestination(row: Int, col: Int): Boolean {
        return row == n - 1 && col == n - 1
    }

    // Perform breadth-first search to find the shortest clear path
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    if (grid[0][0] == 0) {
        queue.offer(Pair(0, 0))
        grid[0][0] = 1 // Mark the start cell as visited
    }

    var pathLength = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        pathLength++

        for (i in 0 until size) {
            val (row, col) = queue.poll()

            if (isDestination(row, col)) {
                return pathLength
            }

            for (direction in directions) {
                val newRow = row + direction[0]
                val newCol = col + direction[1]

                if (isValidCell(newRow, newCol) && grid[newRow][newCol] == 0) {
                    queue.offer(Pair(newRow, newCol))
                    grid[newRow][newCol] = 1 // Mark the cell as visited
                }
            }
        }
    }

    return -1 // No clear path found
}