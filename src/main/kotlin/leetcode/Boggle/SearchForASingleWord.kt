package leetcode.Boggle

fun exists(grid: Array<CharArray>, word: String): Boolean {
    val n = grid.size
    if (n == 0) return false
    val m = grid[0].size
    val visited = Array(n) {BooleanArray(m)}
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (DFS3(grid, word, visited, i, j, 0))
                return true
        }
    }
    return false
}

fun DFS3(grid: Array<CharArray>, word: String, visited: Array<BooleanArray>, i: Int, j: Int, index: Int): Boolean {
    val n = grid.size
    val m = grid[0].size
    if (index == word.length) return true
    if( i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || grid[i][j] != word[index]) {
        return false
    }
    visited[i][j] = true
    val res =
    DFS3(grid, word, visited, i+1, j, index+1) ||
    DFS3(grid, word, visited, i-1, j, index+1) ||
    DFS3(grid, word, visited, i, j+1, index+1) ||
    DFS3(grid, word, visited, i, j-1, index+1)
    visited[i][j] = false
    return res

}
fun main() {
    val grid = arrayOf(
        charArrayOf('C', 'S', 'L', 'I', 'M'),
        charArrayOf('O', 'I', 'L', 'M', 'O'),
        charArrayOf('O', 'L', 'I', 'E', 'O'),
        charArrayOf('R', 'T', 'A', 'S', 'N'),
        charArrayOf('S', 'I', 'T', 'A', 'C'))
    val word = "COIL"
    println(exists(grid, word))
}
