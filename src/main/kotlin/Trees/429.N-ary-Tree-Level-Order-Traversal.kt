package Trees

// recursion
fun levelOrder(root: Node?): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    if (root == null) return res
    traverse(root, 0, res)
    return res
}

fun traverse(node: Node?, level: Int, res: MutableList<List<Int>>) {
    if (node == null) return
    if (level >= res.size) {
        res.add(mutableListOf(node.`val`))
    } else {
        res[level] = res[level] + node.`val`
    }
    for (child in node.children!!) {
        traverse(child, level + 1, res)
    }
}

// iterative
fun levelOrder1(root: Node?): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    if (root == null) return res
    val queue = ArrayDeque<Node>()
    queue.add(root)

    while (!queue.isEmpty()) {
        val level = mutableListOf<Int>()
        for (i in 0 until queue.size) {
            val node = queue.removeFirst()
            level.add(node.`val`)
            node.children!!.forEach { queue.add(it)}
        }
        res.add(level)
    }
    return res
}