package leetcode

internal object Solution1 {
    var numbers = arrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9')

    fun SolveSudoku(board:Array<Array<Char>>) {
        // Write code here
        solve(board, 0, 0)
    }

    private fun solve(board: Array<Array<Char>>, row: Int, column: Int): Boolean {
        // move right until we get to the end and restart at the next row
        if (column == 9) return solve(board, row+1, 0)
        if (row == 9) return true

        //If the current value is not ‘.’, move on to the next position
        if (board[row][column] != '.') return solve(board, row, column+1)

        // tries each digit from 1 to 9 for the cell at board[r][c]. If a digit leads
        // to a solution, then the function returns true. If no digit leads to a solution,
        // then the code backtracks and tries a different digit.
        for (i in numbers) {
            //For each digit i, the code calls the isValidMove function to check
            // if i is a valid digit for the cell at board[row][column].
            // If it is, then the code sets the value of the cell to i.
            if (isValidMove(board, row, column, i)) {
                board[row][column] = i
                // if can solve remaining then done
                // check if the puzzle can be solved with the remaining cells by recursively
                // calling the Solve function with the next cell (r, c+1) as the starting point.
                // If Solve returns true, indicating that the puzzle has been solved,
                // then the function returns true to indicate that the puzzle has been solved.
                if (solve(board, row, column+1)) return true
                // if not, backtracking
                // If 'solve' does not return true, then the code backtracks by setting
                // the value of the current cell back to '.' to indicate that it is empty.
                // This allows the function to try a different digit for the cell at board[row][column] in the next iteration of the loop.
                board[row][column] = '.'
            }
        }
        return false
    }

    private fun isValidMove(board: Array<Array<Char>>, row: Int, column: Int, x: Char): Boolean {
        // check column
        for (i in 0..8) {
            if (board[row][i] == x) return false
        }

        // check row
        for (j in 0..8) {
            if (board[j][column] == x) return false
        }

        //calculate the starting and ending rows of the sub-box
        val firstRow = 3*(row/3)
        val lastRow = 3*(row/3) + 3
        //calculate the starting and ending columns of the sub-box
        val firstCol = 3*(column/3)
        val lastCol = 3*(column/3) + 3
        for (i in firstRow until lastRow) {
            for (j in firstCol until lastCol) {
                if (board[i][j] == x) return false
            }
        }
        return true
    }
}
fun main(){

    var board = arrayOf(
        arrayOf('.','.','.','.','.','.','.','7','.'),
        arrayOf('2','7','5','.','.','.','3','1','4'),
        arrayOf('.','.','.','.','2','7','.','5','.'),
        arrayOf('9','8','.','.','.','.','.','3','1'),
        arrayOf('.','3','1','8','.','4','.','.','.'),
        arrayOf('.','.','.','1','.','.','8','.','5'),
        arrayOf('7','.','6','2','.','.','1','8','.'),
        arrayOf('.','9','.','7','.','.','.','.','.'),
        arrayOf('4','1','.','.','.','5','.','.','7')
    )

    Solution1.SolveSudoku(board);

    var unsolvedBoard = arrayOf(
        arrayOf('.','.','.','.','.','.','.','7','.'),
        arrayOf('2','7','5','.','.','.','3','1','4'),
        arrayOf('.','.','.','.','2','7','.','5','.'),
        arrayOf('9','8','.','.','.','.','.','3','1'),
        arrayOf('.','3','1','8','.','4','.','.','.'),
        arrayOf('.','.','.','1','.','.','8','.','5'),
        arrayOf('7','.','6','2','.','.','1','8','.'),
        arrayOf('.','9','.','7','.','.','.','.','.'),
        arrayOf('4','1','.','.','.','5','.','.','7')
    )

    print("     ");
    print("Unsolved Board");
    print("                        ");
    print("Solution");
    println("");


    for(x in 0..8){
        for(y in 0..8){
            if(y%3 == 0)
                print("  ");
            print(unsolvedBoard[x][y]);
            print(" ");
        }
        print("            ");
        for(y in 0..8){
            if(y%3 == 0)
                print("  ");
            print(board[x][y]);
            print(" ");
        }
        if(x%3 == 2)
            println("");
        println("");
    }
}