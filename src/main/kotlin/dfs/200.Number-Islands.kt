package dfs

fun numIslands(grid: Array<CharArray>): Int {
    val row = grid.size
    val col = grid[0].size
    if (row == 0) return 0
    var count = 0
    val visited = Array(row) {BooleanArray(col)}

    for (i in 0 until row) {
        for (j in 0 until col) {
            if (grid[i][j] == '1' && !visited[i][j]) {
                dfs3(grid, visited, i, j)
                count++
            }
        }
    }
    return count
}

fun dfs3(grid: Array<CharArray>, visited: Array<BooleanArray>, i: Int, j: Int) {
    val row = grid.size
    val col = grid[0].size
    if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0' || visited[i][j]) return
    visited[i][j] = true
    dfs3(grid, visited, i-1, j)
    dfs3(grid, visited, i+1, j)
    dfs3(grid, visited, i, j-1)
    dfs3(grid, visited, i, j+1)
}
