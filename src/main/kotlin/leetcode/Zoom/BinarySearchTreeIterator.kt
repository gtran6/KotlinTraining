package leetcode.Zoom

import java.util.*

class BSTIterator(root: TreeNode?) {
    val stack: Stack<TreeNode> = Stack()

    init {
        pushAllLeftNode(root)
    }

    private fun pushAllLeftNode(root: TreeNode?) {
        var node = root
        while (node != null) {
            stack.push(node)
            node = node.left
        }
    }

    fun next(): Int {
        val nextNode = stack.pop()

        pushAllLeftNode(nextNode.right)

        return nextNode.`val`
    }

    fun hasNext() = stack.size > 0
}
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}