package Trees

import java.util.*

fun levelOrder(root: TreeNode?) {
    if (root == null) return

    val queue: Queue<TreeNode> = LinkedList()
    queue.offer(root)
    while (queue.isNotEmpty()) {
        val node = queue.poll()
        println(node.`val`)

        if (node.left != null) {
            queue.offer(node.left)
        }
        if (node.right != null) {
            queue.offer(node.right)
        }
    }
}
fun main() {
    val root = TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5)), TreeNode(3, TreeNode(6)))
    println(levelOrder(root))
}
/*
The root node (value = 1) is added to the queue.
The node at the front of the queue (value = 1) is removed from the queue and printed. Its left and right child nodes (values = 2 and 3) are added to the end of the queue.
The node at the front of the queue (value = 2) is removed from the queue and printed. Its left and right child nodes (values = 4 and 5) are added to the end of the queue.
The node at the front of the queue (value = 3) is removed from the queue and printed. Its right child node (value = 6) is added to the end of the queue.
The node at the front of the queue (value = 4) is removed from the queue and printed.
The node at the front of the queue (value = 5) is removed from the queue and printed.
The node at the front of the queue (value = 6) is removed from the queue and printed.
The queue is now empty, so the loop exits and the function returns.
 */