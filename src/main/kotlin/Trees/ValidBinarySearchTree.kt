package Trees

fun isValidBST(root: TreeNode?): Boolean {
    return checkBST(root, null, null)
}

fun checkBST(root: TreeNode?, left: Int?, right: Int?): Boolean {
    if (root == null) return true

    if (left != null && root.`val` <= left || right != null && root.`val` >= right)
        return false
    return checkBST(root.left, left, root.`val`) && checkBST(root.right, root.`val`, right)
}
