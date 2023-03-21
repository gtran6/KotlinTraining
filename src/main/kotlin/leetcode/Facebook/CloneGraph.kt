package leetcode.Facebook

class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()
}
fun cloneGraph(node: Node?): Node? {
    if (node == null) return null

    //to keep track of which nodes have already been cloned.
    val visited: MutableMap<Node, Node> = HashMap()
    return cloneNode(node, visited)
}

//The cloneNode function takes in a node from the original graph and the visited map.
fun cloneNode(node: Node, visited: MutableMap<Node, Node>): Node? {
    //If the visited map already contains the node, it simply returns the cloned node.
    if (visited.containsKey(node)) return visited[node]

    //Otherwise, it creates a new Node object with the same value as the original node and adds it to the visited map.
    val clonedNode = Node(node.`val`)
    visited[node] = clonedNode

    //The function then iterates over the original node's neighbors and recursively calls cloneNode on each of them,
    // adding the cloned neighbors to the neighbors list of the cloned node.
    for (i in node.neighbors) {
        clonedNode.neighbors.add(cloneNode(i!!, visited))
    }
    //Finally, the cloneNode function returns the cloned node. Once all nodes have been cloned, the cloneGraph
    // function returns the cloned node corresponding to the original node that was passed in.
    return clonedNode
}
fun main() {
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)

    node1.neighbors.add(node2)
    node1.neighbors.add(node4)

    node2.neighbors.add(node1)
    node2.neighbors.add(node3)

    node3.neighbors.add(node2)
    node3.neighbors.add(node4)

    node4.neighbors.add(node1)
    node4.neighbors.add(node3)

    val clonedNode1 = cloneGraph(node1)
    // print the original graph
    println("Original Graph:")
    printNode(node1)

    // print the cloned graph
    println("Cloned Graph:")
    printNode(clonedNode1)
}

// a helper function to recursively print the nodes in the graph
fun printNode(node: Node?) {
    if (node == null) return
    println("${node.`val`} -> ${node.neighbors.map { it?.`val` }}")
    node.neighbors.forEach { printNode(it) }
}
