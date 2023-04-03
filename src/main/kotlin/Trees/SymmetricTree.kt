package Trees

fun isSymmetric(root: TreeNode?): Boolean {
    if (root == null) return true

    return isMirror(root.left, root.right)
}

fun isMirror(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true
    if (p == null || q == null) return false
    if (p.`val` != q.`val`) return false

    // Recursively check if the left subtree of p is a mirror image of the right subtree of q
    // and if the right subtree of p is a mirror image of the left subtree of q
    return isMirror(p.left, q.right) && isMirror(p.right, q.left)
}
fun main() {
    // Create a symmetric binary tree
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left!!.left = TreeNode(3)
    root.left!!.right = TreeNode(4)
    root.right = TreeNode(2)
    root.right!!.left = TreeNode(4)
    root.right!!.right = TreeNode(3)

    println(isSymmetric(root)) // Output: true

    // Create a non-symmetric binary tree
    val root2 = TreeNode(1)
    root2.left = TreeNode(2)
    root2.left!!.right = TreeNode(3)
    root2.right = TreeNode(2)
    root2.right!!.right = TreeNode(3)

    println(isSymmetric(root2)) // Output: false
}