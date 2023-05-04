package Trees

fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    var curr = root
    while (curr != null) {
        if (curr.`val` == `val`) {
            return curr
        } else if (curr.`val` < `val`) {
            curr = curr.right
        } else {
            curr = curr.left
        }
    }
    return null
}