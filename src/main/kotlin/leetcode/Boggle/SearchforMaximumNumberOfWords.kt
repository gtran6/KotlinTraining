package leetcode.Boggle

fun searchWords(grid: Array<CharArray>, words: Array<String>): Array<String> {
    val result = mutableSetOf<String>()
    for (word in words) {
        if (exists2(grid, word)) {
            result.add(word)
        }
    }
    return result.toTypedArray()
}
fun exists2(grid: Array<CharArray>, word: String): Boolean {
    val n = grid.size
    if (n == 0) return false
    val m = grid[0].size
    val visited = Array(n) {BooleanArray(m)}
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (DFS5(grid, word, visited, i, j, 0))
                return true
        }
    }
    return false
}

fun DFS5(grid: Array<CharArray>, word: String, visited: Array<BooleanArray>, i: Int, j: Int, index: Int): Boolean {
    val n = grid.size
    val m = grid[0].size
    if (index == word.length) return true
    if( i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || grid[i][j] != word[index]) {
        return false
    }
    visited[i][j] = true
    val res =
        DFS5(grid, word, visited, i+1, j, index+1) ||
                DFS5(grid, word, visited, i-1, j, index+1) ||
                DFS5(grid, word, visited, i, j+1, index+1) ||
                DFS5(grid, word, visited, i, j-1, index+1)
    visited[i][j] = false
    return res
}
fun main() {
    val grid = arrayOf(
        charArrayOf('B', 'S', 'L', 'I', 'M'),
        charArrayOf('R', 'I', 'L', 'M', 'O'),
        charArrayOf('O', 'L', 'I', 'E', 'O'),
        charArrayOf('R', 'Y', 'I', 'L', 'N'),
        charArrayOf('B', 'U', 'N', 'E', 'C')

    )
    val words = arrayOf("MOMI", "SLICK", "SLIME", "ONLINE", "NOW")
    println(searchWords(grid, words))
}