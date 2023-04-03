package Trees

fun inOrder(root: TreeNode?) {
    if (root == null) return

    inOrder(root.left)
    println(root.`val`)
    inOrder(root.right)
}
fun main() {
    val root = TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5)), TreeNode(3))
    println(inOrder(root))
}