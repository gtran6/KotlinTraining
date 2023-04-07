package Trees

fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
    if (root1 == null && root2 == null) return true

    return if (root1 == null || root2 == null || root1.`val` != root2.`val`) false
    else flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
            flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)
}
fun main() {
    var root1: TreeNode? = null
    var root2: TreeNode? = null
    println(flipEquiv(root1, root2))

    root1 = TreeNode(1)
    root1.right = TreeNode(3)
    root1.left = TreeNode(2)
    root1.right!!.left = TreeNode(6)
    root1.right!!.right = TreeNode(9)
    root1.left!!.left = TreeNode(4)
    root1.left!!.right = TreeNode(5)
    root1.left!!.right!!.left = TreeNode(7)
    root1.left!!.right!!.right = TreeNode(8)

    root2 = TreeNode(1)
    root2.left = TreeNode(3)
    root2.right = TreeNode(2)
    root2.left!!.right = TreeNode(6)
    root2.left!!.left = TreeNode(9)
    root2.right!!.left = TreeNode(4)
    root2.right!!.right = TreeNode(5)
    root2.right!!.right!!.right = TreeNode(7)
    root2.right!!.right!!.left = TreeNode(8)

    println(flipEquiv(root1, root2))

    val root3 = TreeNode(1)
    root3.right = TreeNode(4)
    root3.left = TreeNode(3)
    val root4 = TreeNode(1)

    println(flipEquiv(root3, root4))
}