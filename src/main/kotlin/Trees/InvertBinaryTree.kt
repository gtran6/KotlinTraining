package Trees

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