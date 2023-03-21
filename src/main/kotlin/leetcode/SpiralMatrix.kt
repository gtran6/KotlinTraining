package leetcode

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    //declaring a new variable called res of type MutableList<Int>,
    // and we are initializing it to a new instance of ArrayList<Int>().
    val res: MutableList<Int> = ArrayList()
    if (matrix.isEmpty()) return res
    var r1 = 0
    var r2 = matrix.size - 1
    var c1 = 0
    var c2 = matrix[0].size - 1

    /*
    Since the algorithm collects the elements in a spiral order, it first
    collects the elements in the top row of the remaining matrix from left to right,
    then collects the elements in the rightmost column of the remaining matrix from
    top to bottom, then collects the elements in the bottom row of the remaining matrix
    from right to left, and finally collects the elements in the leftmost column of
    the remaining matrix from bottom to top.
     */
    while (r1 <= r2 && c1 <= c2) {
        for (c in c1..c2) res.add(matrix[r1][c]) // left to right
        for (r in r1+1..r2) res.add(matrix[r][c2]) // top to bottm

        if (r1 < r2 && c1 < c2) {
            for (c in c2-1 downTo c1+1) res.add(matrix[r2][c]) // right to left
            for (r in r2 downTo r1+1) res.add(matrix[r][c1]) // bottom to top
        }
        r1++
        r2--
        c1++
        c2--
    }
    return res
}
fun main() {
    val matrix = arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8), intArrayOf(9, 10, 11, 12))
    val matrix1 = arrayOf(intArrayOf(1,2), intArrayOf(3,4))
    println(spiralOrder(matrix1))
}