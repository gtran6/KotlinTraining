package Trees
class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode?= null)

fun height(root: TreeNode?) : Int {
    if (root == null) return 0
    return 1 + maxOf(height(root.left), height(root.right))
}
fun main() {
    val root = TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5)), TreeNode(3))
    println(height(root))
}