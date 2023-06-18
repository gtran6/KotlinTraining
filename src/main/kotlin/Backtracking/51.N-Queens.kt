package Backtracking

fun solveNQueens(n: Int): List<List<String>> {
    val solutions = mutableListOf<List<String>>()
    val columns = IntArray(n)

    fun backtrack(row: Int) {
        if (row == n) {
            val solution = mutableListOf<String>()
            for (i in 0 until n) {
                val queenPos = columns[i]
                val rowString = StringBuilder()
                for (j in 0 until n) {
                    rowString.append(if (j == queenPos) 'Q' else '.')
                }
                solution.add(rowString.toString())
            }
            solutions.add(solution)
            return
        }

        for (col in 0 until n) {
            var isValid = true
            for (prevRow in 0 until row) {
                val prevCol = columns[prevRow]
                if (col == prevCol || row - prevRow == col - prevCol || row - prevRow == prevCol - col) {
                    isValid = false
                    break
                }
            }
            if (isValid) {
                columns[row] = col
                backtrack(row + 1)
            }
        }
    }
    backtrack(0)
    return solutions
}
fun main() {
    val n = 4
    println(solveNQueens(n))
}