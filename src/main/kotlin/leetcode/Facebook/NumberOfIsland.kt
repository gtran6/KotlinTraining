package leetcode.Facebook

fun numIslands(islands: List<List<String>>) : Int {
    val n = islands.size
    if (n == 0) {
        return 0
    }
    val m = islands[0].size
    val visited = Array(n) { BooleanArray(m) }
    var count = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (islands[i][j] == "1" && !visited[i][j]) {
                DFS(islands, visited, i, j)
                count++
            }
        }
    }
    return count
}

fun DFS(islands: List<List<String>>, visited: Array<BooleanArray>, i: Int, j: Int) {
    val n = islands.size
    val m = islands[0].size
    if (i < 0 || i >= n || j < 0 || j >= m || islands[i][j] == "0" || visited[i][j]) {
        return
    }
    visited[i][j] = true
    DFS(islands, visited, i+1, j)
    DFS(islands, visited, i-1, j)
    DFS(islands, visited, i, j+1)
    DFS(islands, visited, i, j-1)
}
fun main() {
    val grid = listOf(
        listOf("1", "1", "0", "0", "0"),
        listOf("1", "1", "0", "0", "0"),
        listOf("0", "0", "1", "0", "0"),
        listOf("0", "0", "0", "1", "1")
    )
    println(numIslands(grid))
}