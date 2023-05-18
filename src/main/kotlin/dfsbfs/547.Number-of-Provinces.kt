package dfsbfs

fun findCircleNum(isConnected: Array<IntArray>): Int {
    val n = isConnected.size
    if (n == 0) return 0

    var count = 0
    val visited = BooleanArray(n)

    for (i in 0 until n) {
        if (!visited[i]) {
            DFS1(isConnected, visited, i)
            count++
        }
    }
    return count
}

fun DFS1(isConnected: Array<IntArray>, visited: BooleanArray, i: Int) {
    visited[i] = true
    for (j in isConnected.indices) {
        if (isConnected[i][j] == 1 && !visited[j]) {
            DFS1(isConnected, visited, j)
        }
    }
}
fun main() {
    val isConnected = arrayOf(intArrayOf(1,0,0,1), intArrayOf(0,1,1,0), intArrayOf(0,1,1,1), intArrayOf(1,0,1,1))
    println(findCircleNum(isConnected))
}
