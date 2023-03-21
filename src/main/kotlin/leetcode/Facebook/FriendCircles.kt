package leetcode.Facebook

fun DFS(friends: Array<BooleanArray>, n: Int, visited: BooleanArray, v: Int) {
    for (i in 0 until n) {
        if (friends[v][i] && !visited[i] && i != v) {
            visited[i] = true
            DFS(friends, n, visited, i)
        }
    }
}

fun friendCircles(friends: Array<BooleanArray>, n: Int): Int {
    if (n == 0) return 0
    var numCircles = 0
    val visited = BooleanArray(n) //keeps track of which vertices have already been visited.
    for (i in 0 until n) {
        visited[i] = false //// Initialize visited array to false for all vertices
    }
    //Start with the first user and recursively find all other users in his/her
    //friend circle. Then, do the same thing for the next user that is not already
    //in a friend circle. Repeat until all users are in a friend circle.

    for (i in 0 until n) {
        if (!visited[i]) { // If the vertex has not been visited, start a new circle
            visited[i] = true // Mark the vertex as visited
            DFS(friends, n, visited, i) // Perform DFS to find all vertices in the current circle
            numCircles++ // Increment the number of circles found
        }
    }
    return numCircles
}

fun main() {
    val friends = arrayOf(
        booleanArrayOf(false, true, true, false, false),
        booleanArrayOf(true, false, false, false, false),
        booleanArrayOf(true, false, false, true, false),
        booleanArrayOf(false, false, true, false, true),
        booleanArrayOf(false, false, false, true, false)
    )
    val n = 5
    println(friendCircles(friends, n))
}