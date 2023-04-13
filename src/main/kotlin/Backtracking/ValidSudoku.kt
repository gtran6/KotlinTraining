package Backtracking

fun isValidSudoku(board: Array<CharArray>): Boolean {


    /*// validate rows
    for (i in 0 until 9) {
        val row = mutableSetOf<Char>()
        for (j in 0 until 9) {
            if (board[i][j] == '.') continue
            if (row.contains(board[i][j])) return false
            row.add(board[i][j])
        }
    }

    // validate columns
    for (j in 0 until 9) {
        val col = mutableSetOf<Char>()
        for (i in 0 until 9) {
            if (board[i][j] == '.') continue
            if (col.contains(board[i][j])) return false
            col.add(board[i][j])
        }
    }

    //validate sub-box
    for (i in 0 until 9 step 3) {
        for (j in 0 until 9 step 3) {
            val subBox = mutableSetOf<Char>()
            for (x in i until i+3) {
                for (y in j until j+3) {
                    if (board[x][y] == '.') continue
                    if (subBox.contains(board[x][y])) return false
                    subBox.add(board[x][y])
                }
            }
        }
    }
    return true*/

    val rowSet = Array(9) { mutableSetOf<Char>() }
    val colSet = Array(9) { mutableSetOf<Char>() }
    val subBoxSet = Array(9) { mutableSetOf<Char>() }

    for (i in 0 until 9) {
        for (j in 0 until 9) {
            val digit = board[i][j]
            if (digit == '.') continue

            //check row
            if (!rowSet[i].add(digit)) return false

            //check col
            if (!colSet[i].add(digit)) return false

            //check sub box
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