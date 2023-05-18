package dfsbfs

fun orangesRotting(grid: Array<IntArray>): Int {
    val rows = grid.size
    val cols = grid[0].size

    val queue = ArrayDeque<Pair<Int, Int>>()
    var freshCount = 0

    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (grid[i][j] == 2) {
                queue.add(i to j)
            } else if (grid[i][j] == 1) {
                freshCount++
            }
        }
    }

    var minutes = 0
    val directions = arrayOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)

    while (queue.isNotEmpty() && freshCount > 0) {
        val size = queue.size
        for (i in 0 until size) {
            val (x, y) = queue.removeFirst()
            for ((dx, dy) in directions) {
                val newX = x + dx
                val newY = y + dy
                if (newX in 0 until rows && newY in 0 until cols && grid[newX][newY] == 1) {
                    grid[newX][newY] = 2
                    freshCount--
                    queue.add(newX to newY)
                }
            }
        }
        minutes++
    }

    return if (freshCount == 0) minutes else -1
}
fun main() {
    val grid = arrayOf(intArrayOf(2,1,1), intArrayOf(1,1,0), intArrayOf(0,1,1))
    println(orangesRotting(grid))
}