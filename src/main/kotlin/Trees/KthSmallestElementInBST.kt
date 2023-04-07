package Trees

import java.util.*

fun kthSmallest(root: TreeNode?, k: Int): Int {
    val stack = Stack<TreeNode>()
    var currentNode = root
    var count = 0

    while (currentNode != null || stack.isNotEmpty()) {
        while (currentNode != null) {
            stack.add(currentNode)
            currentNode = currentNode.left
        }

        currentNode = stack.removeLast()
        count++
        if (count == k) {
            return currentNode.`val`
        }

        currentNode = currentNode.right
    }
    return -1
}
fun main() {
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(1)
    root.left?.right = TreeNode(3)
    root.right = TreeNode(5)

    val k = 3
    println(kthSmallest(root, k))
}
/*
- implementation uses an iterative approach and a stack to traverse the tree in-order.
- stack stores nodes that have not been fully processed, the traversal follows the left subtree,
then process the node and then traverses the right subtree
- count variable keeps track of the number of nodes that have been processed so far
- when count equals to k, return the value of the current node
 */