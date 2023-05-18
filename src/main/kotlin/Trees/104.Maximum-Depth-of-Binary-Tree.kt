package Trees

import java.util.Stack

fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0

    val stack = Stack<TreeNode>()
    val depthStack = Stack<Int>()
    stack.push(root)
    depthStack.push(1)
    var maxDepth = 0

    while (stack.isNotEmpty()) {
        val node = stack.pop()
        val currentDepth = depthStack.pop()

        if (node.left == null && node.right == null) {
            // Leaf node, update the maxDepth if needed
            maxDepth = maxOf(maxDepth, currentDepth)
        }

        if (node.left != null) {
            stack.push(node.left)
            depthStack.push(currentDepth + 1)
        }

        if (node.right != null) {
            stack.push(node.right)
            depthStack.push(currentDepth + 1)
        }
    }

    return maxDepth
}