package Trees

fun insert(root: TreeNode?, value: Int) : TreeNode {
    if (root == null) return TreeNode(value)

    if (value < root.`val`) {
        root.left = insert(root.left, value)
    } else if (value > root.`val`) {
        root.right = insert(root.right, value)
    }
    return root
}
fun main() {
    val root = TreeNode(4, TreeNode(2), TreeNode(7))
    insert(root, 1)
    insert(root, 3)
    insert(root, 5)
    insert(root, 6)
    insert(root, 8)
    println(inOrder(root))
}