package Trees

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null) return null
    if (root == p || root == q) return root
    return if (p!!.`val` < root.`val` && q!!.`val` < root.`val`) {
        lowestCommonAncestor(root.left, p, q)
    } else if (p!!.`val` > root.`val` && q!!.`val` > root.`val`) {
        lowestCommonAncestor(root.right, p, q)
    } else {
        root
    }
}