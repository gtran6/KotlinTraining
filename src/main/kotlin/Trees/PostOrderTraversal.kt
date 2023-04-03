package Trees

fun postOrder(root: TreeNode?) {
    if (root == null) return

    postOrder(root.left)
    postOrder(root.right)
    println(root.`val`)
}
fun main() {
    val root = TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5)), TreeNode(3))
    println(postOrder(root))
}