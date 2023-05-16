package Trees

import java.util.Stack

fun invertTree1(root: TreeNode?): TreeNode? {
    if (root == null) return null

    val stack: Stack<TreeNode> = Stack()
    stack.push(root)

    while (!stack.isEmpty()) {
        val node = stack.pop()

        val tmp = node.left
        node.left = node.right
        node.right = tmp

        if (node.left != null) {
            stack.push(node.left!!)
        }

        if (node.right != null) {
            stack.push(node.right!!)
        }
    }
    return root
}
fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return root

    val left = invertTree(root.left)
    root.left = root.right
    root.right = left
    return root
}
fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(5)
    root.right!!.left = TreeNode(6)
    root.right!!.right = TreeNode(7)

    println(invertTree(root))
}