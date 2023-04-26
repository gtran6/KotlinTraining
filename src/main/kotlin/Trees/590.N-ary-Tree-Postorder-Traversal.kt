package Trees

// iterative
fun postorder(root: Node?): List<Int> {
    val res = mutableListOf<Int>()
    if (root == null) return res
    val stack = ArrayDeque<Node>()
    stack.add(root)

    while (!stack.isEmpty()) {
        val node = stack.removeLast()
        res.add(0, node.`val`)
        node.children?.forEach { stack.add(it) }
    }
    return res
}

// recursive
fun postorde2(root: Node?): List<Int> {
    val res = mutableListOf<Int>()
    if (root == null) return res
    traverse(root, res)
    return res
}
fun traverse(node: Node?, res: MutableList<Int>) {
    if (node == null) return
    node.children?.forEach {
        traverse(it, res)
    }
    res.add(node.`val`)
}