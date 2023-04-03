package TreeDepthFirstSearch

fun flatten(root: TreeNode?): Unit {
    if (root == null) return
    flatten(root.left)
    flatten(root.right)

    val tmp = root.right
    root.right = root.left
    root.left = null
    var node = root

    while (node?.right != null) {
        node = node.right
    }
    node?.right = tmp
}
fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(5)
    root.left!!.left = TreeNode(3)
    root.left!!.right = TreeNode(4)
    root.right!!.right = TreeNode(6)
    println(flatten(root))
}