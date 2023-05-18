package dfsbfs

fun solve(board: Array<CharArray>): Unit {
    if (board.isEmpty()) return

    val rows = board.size
    val cols = board[0].size

    // mark all 'O's on the border as visited
    for (i in 0 until rows) {
        markVisited(board, i, 0)
        markVisited(board, i, cols - 1)
    }
    for (j in 0 until cols) {
        markVisited(board, 0, j)
        markVisited(board, rows - 1, j)
    }

    // flip all 'O's that are not visited to 'X'
    // and all visited cells back to 'O'
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (board[i][j] == 'O' && !visited(board, i, j)) {
                board[i][j] = 'X'
            } else if (board[i][j] == 'V') {
                board[i][j] = 'O'
            }
        }
    }
}

// mark all 'O's that are connected to the current 'O' as visited
fun markVisited(board: Array<CharArray>, row: Int, col: Int) {
    if (row < 0 || row >= board.size || col < 0 || col >= board[0].size || board[row][col] != 'O') {
        return
    }

    board[row][col] = 'V'
    markVisited(board, row - 1, col)
    markVisited(board, row + 1, col)
    markVisited(board, row, col - 1)
    markVisited(board, row, col + 1)
}

// check if the current cell has been visited during the markVisited process
fun visited(board: Array<CharArray>, row: Int, col: Int): Boolean {
    return row < 0 || row >= board.size || col < 0 || col >= board[0].size || board[row][col] == 'V'
}

