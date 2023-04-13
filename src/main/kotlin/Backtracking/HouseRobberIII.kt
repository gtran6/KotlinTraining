package Backtracking

import TreeDepthFirstSearch.TreeNode

fun rob(root: TreeNode?): Int {
/*    this solution causes "time limit exceeded" because:
- it's repeatedly traversing the same nodes in the binary tree, causing redundant computation
and slowing down the overall execution time
- the binary tree is very large, which can increase the amount of time it takes to traverse and
compute the maximum amount that can be robbed

    if (root == null) return 0

    //Compute the maximum amount of money that can be robbed with the parent node included.
    val parentMax = root.`val` + rob(root.left?.left) + rob(root.left?.right) + rob(root.right?.left) + rob(root.right?.right)
    //Compute the maximum amount of money that can be robbed with the parent node excluded.
    val childrenMax = rob(root.left) + rob(root.right)

    return maxOf(parentMax, childrenMax)
*/

    // using dynamic programming to store and reuse previously computed sub-problems or
    // by implementing an iterative solution using a stack  or queue to avoid the overhead of recursion

    val memo = mutableMapOf<TreeNode, Int>()
    return robHelper(root, memo)
}

fun robHelper(root: TreeNode?, memo: MutableMap<TreeNode, Int>): Int {
    if (root == null) return 0
    if (memo.containsKey(root)) return memo[root]!!

    var parentMax = root.`val`
    if (root.left != null) {
        parentMax += robHelper(root.left?.left, memo) + robHelper(root.left?.right, memo)
    }

    if (root.right != null) {
        parentMax += robHelper(root.right?.left, memo) + robHelper(root.right?.right, memo)
    }

    val childrenMax = robHelper(root.left, memo) + robHelper(root.right, memo)
    val max = maxOf(parentMax, childrenMax)
    memo[root] = max
    return max

}

fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.right = TreeNode(3)
    root.right?.right = TreeNode(1)
    println(rob(root))
}