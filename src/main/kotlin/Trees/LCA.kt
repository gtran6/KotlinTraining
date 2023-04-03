package Trees

fun LCA(root: TreeNode?, p: TreeNode, q: TreeNode) : TreeNode? {
    if (root == null) return null
    if (root == p || root == q) return root

    val left = LCA(root.left, p, q)
    val right = LCA(root.right, p, q)

    return when {
        left != null && right != null -> root
        left != null -> left
        else -> right
    }
}

fun main() {
    val root = TreeNode(3,
        TreeNode(5, TreeNode(6), TreeNode(2, TreeNode(7), TreeNode(4))),
        TreeNode(1, TreeNode(0), TreeNode(8)))
    val p = root.left!!.left // Node with value 6
    val q = root.left!!.right!!.right // Node with value 4
    val lca = LCA(root, p!!, q!!)
    println("Lowest common ancestor of ${p.`val`} and ${q.`val`} is ${lca?.`val`}")
}
/*
          3
        /   \
       5     1
      / \   / \
     6   2 0   8
        / \
       7   4

- start at the root of the tree which is the node with value 3
- check if the current node is null or if it is equal to either of the 2 nodes we are looking for (6 and 4)
In this case, the current node is not null and is not equal to either 6 or 4, so we move on to the next step
- recursively call the LCA function on the left and right subtree of the current node,
for the left subtree, we start at node 5 and search for both 6 and 4
for the right subtree, we start at node 1 and search for both 6 and 4
In this case, node 5 is not equal to either 6 or 4, so we move on to its left and right subtrees.
Node 1 is not equal to either 6 or 4, so we move on to its left and right subtrees.
- recursively call the LCA on the left and right subtrees of the current node 5
The node 6 is found, so we return it up the recursive call stack.
- recursively call the LCA on the left and right subtrees of the current node 2
The node 4 is found, so we return it up the recursive call stack.
- Now we have found two non-null nodes returned from the recursive calls 6 and 4. this means that the LCA of
6 and 4 is the current node we are on, which is the node 5
- return the LCA node up the recursive call stack until we reach the root node.
 */