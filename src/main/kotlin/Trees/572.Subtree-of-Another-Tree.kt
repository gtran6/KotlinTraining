package Trees

fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
    if (root == null) return false
    return equal(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
}
fun equal(s: TreeNode?, t: TreeNode?) : Boolean {
    if (s == null && t == null) return true
    if (s == null || t == null) return false
    if (s.`val` != t.`val`) return false
    return equal(s.left, t.left) && equal(s.right, t.right)
}