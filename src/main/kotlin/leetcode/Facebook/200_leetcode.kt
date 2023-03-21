package leetcode.Facebook

fun numIslands(grid: Array<CharArray>): Int {
    /*
    These lines define two variables n and m, which represent the number of rows and columns in the grid,
    respectively. The if statement checks if n is 0, which would mean the grid is empty, and if so, immediately returns 0.
     */
    val n = grid.size
    if (n == 0) return 0
    val m = grid[0].size
    var count = 0 //keep track of the number of islands found in the grid

    //visited is a 2D boolean array that will be used to keep track of which
    // cells have been visited during the search for islands.
    val visited = Array(n) {BooleanArray(m)}

    for (i in 0 until n) {
        for (j in 0 until m) {
            // The if statement checks if the current cell contains a '1'
            // and has not been visited before, and if so, calls the DFS
            // function to search for all connected cells that also contain a '1'.
            if (grid[i][j] == '1' && !visited[i][j]) {
                DFS(grid, visited, i, j)
                //Once the search is complete, count is incremented to indicate that a new island has been found.
                count++
            }
        }
    }
    return count
}
/*
This is the DFS function, it takes in the same inputs as the numIslands function,
as well as the coordinates of the current cell being searched. The if statement checks if the current cell is out of
bounds, contains a '0', or has already been visited, and if so, returns without doing anything. Otherwise, it marks
the current cell as visited and recursively calls itself on each of its neighboring cells that contain a '1'.
 */
fun DFS(grid: Array<CharArray>, visited: Array<BooleanArray>, i: Int, j: Int) {
    val n = grid.size
    val m = grid[0].size
    if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0' || visited[i][j]) return

    visited[i][j] = true
    DFS(grid, visited, i+1, j)
    DFS(grid, visited, i-1, j)
    DFS(grid, visited, i, j+1)
    DFS(grid, visited, i, j-1)
}

fun main() {
    val grid = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0'))
    println(numIslands(grid))
}
