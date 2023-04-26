package Trees

class Node(var `val`: Int) {
    var children: List<Node>? = listOf()
}
//Recursion
fun preorder(root: Node?): List<Int> {
    val res = mutableListOf<Int>()
    if (root == null) return res
    res.add(root.`val`)
    for (child in root.children!!) {
        res.addAll(preorder(child))
    }
    return res
}
//Iterative
fun preorder2(root: Node?): List<Int> {
    val res = mutableListOf<Int>()
    if (root == null) return res
    val stack = ArrayDeque<Node>()
    stack.add(root)

    while (!stack.isEmpty()) {
        val node = stack.removeLast()
        res.add(node.`val`)
        for (i in node.children!!.size - 1 downTo 0) {
            val child = node.children!![i]
            stack.add(child)
        }
    }
    return res
}