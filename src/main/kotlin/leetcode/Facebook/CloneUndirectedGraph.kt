package leetcode.Facebook

internal class Node1(var data: Int) {
    var neighbors= ArrayList<Node1>()
}

internal object Graph {
    fun clone(rootNode: Node1?): Node1? {
        if (rootNode == null) return null

        val visited: MutableMap<Node1, Node1> = HashMap()
        return cloneNode1(rootNode, visited)
    }
    fun cloneNode1(rootNode: Node1, visited: MutableMap<Node1, Node1>): Node1? {
        if (visited.containsKey(rootNode)) return visited[rootNode]

        val clonedNode = Node1(rootNode.data)
        visited[rootNode] = clonedNode

        for (i in rootNode.neighbors) {
            clonedNode.neighbors.add(cloneNode1(i, visited)!!)
        }
        return clonedNode
    }
}

fun main() {

}