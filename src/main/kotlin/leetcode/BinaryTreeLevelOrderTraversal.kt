package leetcode

import java.lang.StringBuilder

class TreeNode4(v:String) {
   var value = v;
   var children = ArrayList<TreeNode4>()
}
fun traverse(root: TreeNode4?) : String {
    if(root == null) return ""

    val queue = ArrayDeque<TreeNode4>()
    queue.add(root)

    val result = StringBuilder()
    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        result.append(node.value).append(" ")

        for (child in node.children) {
            queue.add(child)
        }
    }
    return result.trim().toString()
}
fun main() {
    val root = TreeNode4("A")
    val nodeB = TreeNode4("B")
    val nodeC = TreeNode4("C")
    val nodeD = TreeNode4("D")
    val nodeE = TreeNode4("E")
    val nodeF = TreeNode4("F")
    val nodeG = TreeNode4("G")
    val nodeH = TreeNode4("H")

    root.children.add(nodeB)
    root.children.add(nodeC)
    root.children.add(nodeD)
    nodeB.children.add(nodeE)
    nodeB.children.add(nodeF)
    nodeD.children.add(nodeG)
    nodeD.children.add(nodeH)
    val result = traverse(root)
    println(result)
}

/*
     A
   / | \
  B  C  D
 / \   / \
E   F G   H

After adding the root node A to the queue, the queue now contains only the node A.

In the first iteration of the while loop, we dequeue the first node A using queue.removeFirst(),
and append its value "A" to the result string. We then add its child nodes B, C, and D to the queue
using queue.add(child). The queue now contains the nodes B, C, and D in that order.

In the second iteration of the loop, we dequeue the first node B using queue.removeFirst(), append
its value "B" to the result string, and add its child nodes E and F to the queue. The queue now contains
the nodes C, D, E, and F in that order.

We continue this process until the queue is empty, which happens after we have dequeued and processed all
nodes in the tree. So adding the root node A to the queue is just the starting point for the BFS traversal algorithm.

*/