package Trees

//recursion
fun postorderTraversal(root: TreeNode?): List<Int> {
    val res = mutableListOf<Int>()
    if (root == null) return res

    res.addAll(postorderTraversal(root.left))
    res.addAll(postorderTraversal(root.right))
    res.add(root.`val`)

    return res
}
//iteration
fun postorderTraversal1(root: TreeNode?): List<Int> {
    val res = mutableListOf<Int>()
    if (root == null) return res
    val stack = ArrayDeque<TreeNode>()
    var curr: TreeNode? = root

    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.add(curr)
            curr = curr.left
        }
        curr = stack.last()

        if (curr.right != null) {
            curr = curr.right
        } else {
            curr = stack.removeLast()
            res.add(curr.`val`)

            while (stack.isNotEmpty() && curr == stack.last().right) {
                curr = stack.removeLast()
                res.add(curr.`val`)
            }
            curr = null
        }
/*        val node = stack.removeFirst()
        res.add(node.`val`)
        node.left.let {
            stack.addFirst(it!!)
        }
        node.right.let {
            stack.addFirst(it!!)
        }*/
    }
    return res
}