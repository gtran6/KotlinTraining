package Trees

fun isValidBST1(root: TreeNode?): Boolean {
    return checkBST1(root, null, null)
}

fun checkBST1(root: TreeNode?, left: Int?, right: Int?): Boolean {
    if (root == null) return true

    if (left != null && root.`val` <= left || right != null && root.`val` >= right) return false

    return checkBST1(root.left, left, root.`val`) && checkBST1(root.right, root.`val`, right)
}
