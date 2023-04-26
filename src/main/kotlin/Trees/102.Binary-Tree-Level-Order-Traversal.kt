package Trees

// recursion
fun levelOrder2(root: TreeNode?): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    if (root == null) return res
    traverse(root, 0, res)
    return res
}
fun traverse(node: TreeNode?, level: Int, res: MutableList<List<Int>>) {
    if (node == null) return
    if (level >= res.size) {
        res.add(mutableListOf(node.`val`))
    } else {
        res[level] = res[level] + (node.`val`)
    }
    traverse(node.left, level+1, res)
    traverse(node.right, level+1, res)
}

// iterative
fun levelOrder3(root: TreeNode?): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    if (root == null) return res
    val stack = ArrayDeque<TreeNode>()
    stack.add(root)

    while (!stack.isEmpty()) {
        val levelNodes = mutableListOf<Int>()

        for (i in 0 until stack.size) {
            val node = stack.removeLast()
            levelNodes.add(node.`val`)

            if (node.right != null) {
                stack.add(node.right!!)
            }
            if (node.left != null) {
                stack.add(node.left!!)
            }
        }
        res.add(levelNodes)
    }
    return res
}