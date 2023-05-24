package Backtracking

fun exist1(board: Array<CharArray>, word: String): Boolean {
    val rows = board.size
    val cols = board[0].size
    val visited = Array(rows) { BooleanArray(cols) { false } }

    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (dfs(board, word, i, j, 0, visited)) {
                return true
            }
        }
    }

    return false
}

private fun dfs(
    board: Array<CharArray>,
    word: String,
    row: Int,
    col: Int,
    index: Int,
    visited: Array<BooleanArray>
) : Boolean {
    if (index == word.length) {
        // The entire word has been found
        return true
    }

    if (row < 0 || col < 0 || row >= board.size || col >= board[0].size) {
        // Out of bounds
        return false
    }

    if (visited[row][col] || board[row][col] != word[index]) {
        // Current cell has been visited or doesn't match the current character
        return false
    }

    visited[row][col] = true

    val directions = arrayOf(-1, 0, 1, 0, -1)
    for (d in 0 until 4) {
        val newRow = row + directions[d]
        val newCol = col + directions[d + 1]

        if (dfs(board, word, newRow, newCol, index + 1, visited)) {
            visited[row][col] = false // Mark current cell as unvisited before backtracking
            return true
        }
    }

    visited[row][col] = false // Mark current cell as unvisited after trying all directions
    return false
}
fun main() {
    val board = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E')
    )
    val word = "ABCCED"
    println(exist1(board, word))
}