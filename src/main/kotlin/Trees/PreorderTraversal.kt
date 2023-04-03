package Trees

fun preOrder(root: TreeNode?) {
    if (root == null) return

    println( root.`val`)
    preOrder(root.left)
    preOrder(root.right)
}
fun main() {
    val root = TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5)), TreeNode(3 ))
    println(preOrder(root))
}