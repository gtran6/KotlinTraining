package Trees

//recursion
fun preorderTraversal(root: TreeNode?): List<Int> {
    val res = mutableListOf<Int>()
    if (root == null) return res
    res.add(root.`val`)
    res.addAll(preorderTraversal(root.left))
    res.addAll(preorderTraversal(root.right))

    return res
}

//iterative
fun preorderTraversal1(root: TreeNode?): List<Int> {
    val res = mutableListOf<Int>()
    if (root == null) return res
    val stack = ArrayDeque<TreeNode>()
    stack.add(root)

    while (!stack.isEmpty()) {
        val node = stack.removeLast()
        res.add(node.`val`)
        //The reason we push the right child node onto the stack
        // first is that we want to visit the left child node
        // before the right child node in the preorder traversal.
        if (node.left != null) stack.add(node.left!!)
        if (node.right != null) stack.add(node.right!!)
    }
    return res
}