package leetcode.Boggle

fun findStrings(grid: Array<CharArray>, strings: Array<String>): Array<String>? {
    val result = mutableSetOf<String>()
    for (string in strings) {
        if (exists3(grid, string)) {
            result.add(string)
        }
    }
    return result.toTypedArray()
}

fun exists3(grid: Array<CharArray>, string: String): Boolean {
    val n = grid.size
    val m = grid[0].size
    if (n == 0) return false
    val visited = Array(n) {BooleanArray(m)}
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (DFS6(grid, string, 0, visited, i, j))
                return true
        }
    }
    return false
}

fun DFS6(grid: Array<CharArray>, string: String, index: Int, visited: Array<BooleanArray>, i: Int, j: Int): Boolean {
    val n = grid.size
    val m = grid[0].size
    if (index == string.length) return true
    if (i<0 || i>=n || j<0 || j>=m || visited[i][j] || grid[i][j] != string[index]) return false
    visited[i][j] = true
    val res = DFS6(grid, string, index+1, visited, i+1, j) ||
            DFS6(grid, string, index+1, visited, i-1, j) ||
            DFS6(grid, string, index+1, visited, i, j+1) ||
            DFS6(grid, string, index+1, visited, i, j-1)
    visited[i][j] = false
    return res
}
fun main() {
    val grid = arrayOf(
        charArrayOf('C', 'O', 'L', 'I', 'M'),
        charArrayOf('I', 'N', 'L', 'M', 'O'),
        charArrayOf('A', 'L', 'I', 'E', 'O'),
        charArrayOf('R', 'T', 'A', 'S', 'N'),
        charArrayOf('S', 'I', 'T', 'A', 'C')
    )
    val strings = arrayOf("REINDEER", "IN", "RAIN")
    println(findStrings(grid, strings))
}
