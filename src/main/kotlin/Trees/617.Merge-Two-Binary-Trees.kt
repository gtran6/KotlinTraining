package Trees

import java.util.Stack

fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if (root1 == null) return root2
    if (root2 == null) return root1

    root1.`val` += root2.`val`
    root1.left = mergeTrees(root1.left, root2.left)
    root1.right = mergeTrees(root1.right, root2.right)
    return root1
}
fun mergeTrees2(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if (root1 == null) return root2
    if (root2 == null) return root1

    val stack = Stack<Pair<TreeNode, TreeNode>>()
    stack.push(Pair(root1, root2))

    while (!stack.isEmpty()) {
        val (node1, node2) = stack.pop()
        node1.`val` += node2.`val`

        if (node1.left == null) {
            node1.left = node2.left
        } else if (node2.left != null) {
            stack.push(Pair(node1.left, node2.left) as Pair<TreeNode, TreeNode>?)
        }
        if (node1.right == null) {
            node1.right = node2.right
        } else if (node2.right != null) {
            stack.push(Pair(node1.right, node2.right) as Pair<TreeNode, TreeNode>?)
        }
    }
    return root1
}