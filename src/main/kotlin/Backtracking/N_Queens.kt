package Backtracking

fun countNQueens(n: Int) : Int {
    var count = 0
    val columns = IntArray(n)

    fun backtrack(row: Int) {
        if (row == n) {
            count++
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
    return count
}
fun main() {
    val n = 7
    println(countNQueens(n))
}