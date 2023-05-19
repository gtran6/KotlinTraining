package dfsbfs

// dfs
fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
    val n = graph.size
    val paths = mutableListOf<List<Int>>()
    val currentPath = mutableListOf<Int>()

    // Helper function to perform DFS
    fun dfs(node: Int) {
        // Add the current node to the current path
        currentPath.add(node)

        // If the current node is the target node (n - 1), add the current path to the result
        if (node == n - 1) {
            paths.add(ArrayList(currentPath))
        } else {
            // Explore all the neighbors of the current node
            for (neighbor in graph[node]) {
                dfs(neighbor)
            }
        }

        // Remove the current node from the current path
        currentPath.removeAt(currentPath.size - 1)
    }

    // Start the DFS from the source node (0)
    dfs(0)
    return paths
}
//time complexity O(N * P)
fun allPathsSourceTarget1(graph: Array<IntArray>): List<List<Int>> {
    val n = graph.size
    val paths = mutableListOf<List<Int>>()
    val memo = Array<MutableList<List<Int>>>(n) { mutableListOf() }

    fun dfs(node: Int): List<List<Int>> {
        if (memo[node].isNotEmpty()) {
            return memo[node]
        }

        val currentPath = mutableListOf<List<Int>>()

        if (node == n - 1) {
            currentPath.add(listOf(n - 1))
        } else {
            for (neighbor in graph[node]) {
                val neighborPaths = dfs(neighbor)
                for (neighborPath in neighborPaths) {
                    val path = mutableListOf(node)
                    path.addAll(neighborPath)
                    currentPath.add(path)
                }
            }
        }

        memo[node] = currentPath
        return currentPath
    }

    return dfs(0)
}
fun main() {
    val graph = arrayOf(intArrayOf(1,2), intArrayOf(3), intArrayOf(3), intArrayOf())
    println(allPathsSourceTarget(graph))
}