package leetcode

class TreeNode6 internal constructor(var `val`: Int) {
    var left: TreeNode6? = null
    var right: TreeNode6? = null
}

fun LCA(root: TreeNode6?, p: TreeNode6?, q: TreeNode6?): TreeNode6? {
    if (root == null || p == root || q == root) return root

    val left = LCA(root?.left, p, q)
    val right = LCA(root?.right, p, q)

    if (left != null && right != null) {
        return root
    }

    return left ?: right
}
fun main() {
    // create tree
    val root = TreeNode6(3)
    val node1 = TreeNode6(5)
    val node2 = TreeNode6(1)
    val node3 = TreeNode6(6)
    val node4 = TreeNode6(2)
    val node5 = TreeNode6(0)
    val node6 = TreeNode6(8)
    val node7 = TreeNode6(7)
    val node8 = TreeNode6(4)

    root.left = node1
    root.right = node2
    node1.left = node3
    node1.right = node4
    node2.left = node5
    node2.right = node6
    node4.left = node7
    node4.right = node8

    // test case 1
    val result1 = LCA(root, node5, node4)
    println(result1?.`val`) // expected output: 3

    // test case 2
    val result2 = LCA(root, node1, node2)
    println(result2?.`val`) // expected output: 3

    // test case 3
    val result3 = LCA(root, node1, node8)
    println(result3?.`val`) // expected output: 5
}
