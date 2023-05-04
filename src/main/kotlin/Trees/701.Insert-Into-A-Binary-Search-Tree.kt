package Trees

fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
    if (root == null) return TreeNode(`val`)
    var curr = root
    while (curr != null) {
        if (curr.`val` < `val`) {
            if (curr.right == null) {
                curr.right = TreeNode(`val`)
                break
            } else {
                curr = curr.right
            }
        } else {
            if (curr.left == null) {
                curr.left = TreeNode(`val`)
                break
            } else {
                curr = curr.left
            }
        }
    }
    return root
}