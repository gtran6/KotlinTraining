package leetcode

class TreeNode5(var `val`: Int) {
    var left: TreeNode5? = null
    var right: TreeNode5? = null
}

fun levelOrder(root: TreeNode5?): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    if (root == null) return result

    val queue = ArrayDeque<TreeNode5>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val level = mutableListOf<Int>()

        for (i in 0 until queue.size) {
            val node = queue.removeFirst()
            level.add(node.`val`)
            if (node.left != null) {
                queue.add(node.left!!)
            }
            if (node.right != null) {
                queue.add(node.right!!)
            }
        }
        result.add(level)
    }
    return result
}
fun main() {
    val root = TreeNode5(3)
    root.left = TreeNode5(9)
    root.right = TreeNode5(20)
    root.left?.left = TreeNode5(15)
    root.left?.right = TreeNode5(7)
    val result = levelOrder(root)
    println(result)
}