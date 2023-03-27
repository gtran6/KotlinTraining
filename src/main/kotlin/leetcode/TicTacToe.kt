package leetcode

import java.lang.Math.abs

class TicTacToe(n: Int) {
    var rows: IntArray = IntArray(n)
    var cols: IntArray = IntArray(n)
    var diagonal = 0
    var antiDiagonal = 0

    fun move(row: Int, col: Int, player: Int): Int {
        val currentPlayer: Int = if (player == 1) 1 else -1

        // update currentPlayer in rows and cols arrays
        rows[row] += currentPlayer
        cols[col] += currentPlayer

        // update diagonal
        if (row == col) {
            diagonal += currentPlayer
        }
        if (col == cols.size - row - 1) {
            antiDiagonal += currentPlayer
        }
        val n: Int = rows.size
        // check if the currentPlayer wins
        return if (abs(rows[row]) == n || abs(cols[col]) == n || abs(diagonal) == n || abs(antiDiagonal) == n) {
            player
        } else 0
        // No one wins
    }
}

fun main() {
    val input = arrayOf(
        intArrayOf(3),
        intArrayOf(0,0,1),
        intArrayOf(0,2,2),
        intArrayOf(2,2,1),
        intArrayOf(1,1,2),
        intArrayOf(2,0,1),
        intArrayOf(1,0,2),
        intArrayOf(2,1,1))
    val ticTacToe = TicTacToe(input[0][0])
    var win:Int
    for (i in 1 until input.size) {
        println("Player " + input[i][2] + " makes a move at (" + input[i][0] + ", " + input[i][1] + ")")
        win = ticTacToe.move(input[i][0], input[i][1], input[i][2])
        if (win == 0) {
            println("No one wins")
        } else {
            println("Player $win wins")
            break
        }
    }
}