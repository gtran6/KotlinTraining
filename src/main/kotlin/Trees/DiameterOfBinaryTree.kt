package Trees

private var maxDiameter = 0

fun diameterOfBinaryTree(root: TreeNode?): Int {
    calculatePassedNodeCount(root)
    return maxDiameter
}

private fun calculatePassedNodeCount(root: TreeNode?): Int {
    if (root == null) return 0
    val left = calculatePassedNodeCount(root.left)
    val right = calculatePassedNodeCount(root.right)

    // Update the result of diameter of using specific node as root
    maxDiameter = maxOf(maxDiameter, left + right)

    val count = maxOf(left, right) + 1

    return count
}
