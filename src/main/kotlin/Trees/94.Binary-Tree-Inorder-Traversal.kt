package Trees

//recursion
fun inorderTraversal(root: TreeNode?): List<Int> {
    val res = mutableListOf<Int>()
    if (root == null) return res
    res.addAll(inorderTraversal(root.left))
    res.add(root.`val`)
    res.addAll(inorderTraversal(root.right))
    return res
}

//iteration
fun inorderTraversal1(root: TreeNode?): List<Int> {
    val res = mutableListOf<Int>()
    if (root == null) return res
    val stack = ArrayDeque<TreeNode>()
    var curr: TreeNode? = root

    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.add(curr)
            curr = curr.left
        }
        curr = stack.removeLast()
        res.add(curr.`val`)
        curr = curr.right
    }
    return res
}
/*
In this code, we first add the root node to the stack.
Then, in each iteration, we check if the current node has a left child.
If it does, we add the left child to the stack.
Then we add the current node's value to the result list and set curr to
the right of the current node.

This way, we are visiting the left subtree first, then the root,
and then the right subtree, which is the correct order for an inorder traversal.
 */