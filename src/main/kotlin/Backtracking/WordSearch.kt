package Backtracking

fun searchDFS(board: Array<CharArray>, word: String, index: Int, visited: Array<BooleanArray>, i: Int, j: Int): Boolean {
    val n = board.size
    val m = board[0].size
    if (index == word.length) return true
    if (i<0 || i>=n || j <0 || j>=m || visited[i][j] || board[i][j] != word[index]) return false
    visited[i][j] = true
    val res = searchDFS(board, word, index+1, visited, i+1, j) ||
            searchDFS(board, word, index+1, visited, i-1, j) ||
            searchDFS(board, word, index+1, visited, i, j+1) ||
            searchDFS(board, word, index+1, visited, i, j-1)
    visited[i][j] = false
    return res
}

fun exist(board: Array<CharArray>, word: String) : Boolean {
    val n = board.size
    val m = board[0].size
    if (n == 0) return false
    val visited = Array(n) {BooleanArray(m)}
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (searchDFS(board, word, 0, visited, i, j)) return true
        }
    }
    return false
}
fun main() {
    val board = arrayOf(
        charArrayOf('N', 'W', 'L', 'I', 'M'),
        charArrayOf('V', 'I', 'L', 'Q', 'O'),
        charArrayOf('O', 'L', 'A', 'T', 'O'),
        charArrayOf('R', 'T', 'A', 'I', 'N'),
        charArrayOf('O', 'I', 'T', 'N', 'C')
    )
    val word = "LATIN"
    println(exist(board, word))
}