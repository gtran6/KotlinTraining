package dfsbfs

fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    if (grid.isEmpty()) return 0

    val rows = grid.size
    val cols = grid[0].size

    var max = 0

    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (grid[i][j] == 1) {
                max = maxOf(max, dfs4(grid, i, j))
            }
        }
    }
    return max
}

fun dfs4(grid: Array<IntArray>, i: Int, j: Int) : Int {
    val rows = grid.size
    val cols = grid[0].size
    if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0) return 0
    grid[i][j] = 0
    val area = 1 +
    dfs4(grid, i-1, j) +
    dfs4(grid, i+1, j) +
    dfs4(grid, i, j-1) +
    dfs4(grid, i, j+1)
    return area
}
fun main() {
    val grid = arrayOf(
        intArrayOf(0,0,1,0,0,0,0,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,1,1,1,0,0,0),
        intArrayOf(0,1,1,0,1,0,0,0,0,0,0,0,0),
        intArrayOf(0,1,0,0,1,1,0,0,1,0,1,0,0),
        intArrayOf(0,1,0,0,1,1,0,0,1,1,1,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,1,0,0),
        intArrayOf(0,0,0,0,0,0,0,1,1,1,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,1,1,0,0,0,0)
    )
    println(maxAreaOfIsland(grid))
}
