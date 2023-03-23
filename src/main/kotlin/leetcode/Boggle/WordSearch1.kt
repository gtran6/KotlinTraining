package leetcode.Boggle

fun findString(grid: Array<CharArray>, str: String): Boolean {
    val n = grid.size
    val m = grid[0].size
    val visited = Array(n) {BooleanArray(m)}
    if (n == 0) return false

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (DFS4(grid, str, 0, i, j, visited))
                return true
        }
    }
    return false
}

fun DFS4(grid: Array<CharArray>, str: String, index: Int, i: Int, j: Int, visited: Array<BooleanArray>): Boolean {
    val n = grid.size
    val m = grid[0].size
    /*
    If index ever reaches the length of the word, it means that we have found all the characters of the word in
    the grid, in the correct order. In this case, we can return true because the word has been found.
     */
    if (index == str.length) return true
    if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || grid[i][j] != str[index]) return false
    visited[i][j] = true
    val res = DFS4(grid, str, index+1, i+1, j, visited) ||
            DFS4(grid, str, index+1, i-1, j, visited) ||
            DFS4(grid, str, index+1, i, j+1, visited) ||
            DFS4(grid, str, index+1, i, j-1, visited)
    visited[i][j] = false
    return res
}
fun main() {
    val grid = arrayOf(
        charArrayOf('H', 'O', 'L', 'I', 'K'),
        charArrayOf('O', 'M', 'L', 'M', 'E'),
        charArrayOf('O', 'E', 'I', 'A', 'Y'),
        charArrayOf('R', 'T', 'A', 'S', 'O'),
        charArrayOf('S', 'I', 'T', 'T', 'R')
    )
    val str = "MAYOR"
    println(findString(grid,str))
}
