package Trees

fun flatten(root: TreeNode?): Unit {
    if (root == null) return
    val left = root.left
    val right = root.right
    flatten(left)
    flatten(right)
    if (left != null) {
        root.right = left
        root.left = null

        val rightOfLeft = subtreeLast(left)
        rightOfLeft?.right = right
    }
}

private fun subtreeLast(node: TreeNode?): TreeNode? {
    return if (node?.right != null) subtreeLast(node.right!!)
    else node
}
