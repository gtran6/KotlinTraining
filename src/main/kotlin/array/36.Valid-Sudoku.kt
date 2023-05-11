package array
// base on Contains Duplicate problem logic
fun isValidSudoku(board: Array<CharArray>): Boolean {
    val rowSet = Array(9) { mutableSetOf<Char>() }
    val colSet = Array(9) { mutableSetOf<Char>() }
    val subBoxSet = Array(9) { mutableSetOf<Char>() }

    for (i in board.indices) {
        for (j in board.indices) {
            val digit = board[i][j]
            if (digit == '.') continue
            if (!rowSet[i].add(digit)) return false
            if (!colSet[i].add(digit)) return false
            val subBoxIndex = (i/3)*3 + (j/3)
            if (!subBoxSet[subBoxIndex].add(digit)) return false
        }
    }
    return true
}
fun main() {
    val board = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )
    println(isValidSudoku(board))
}