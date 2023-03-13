package leetcode

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/*
Here's the algorithm to calculate the LCA (Lowest Common Ancestor) of two nodes a and b in a binary tree:

1. Start at the root of the tree.

2. Traverse down the tree until you find either a or b.

3. For each node visited, keep track of its parent node. This can be done using a parent pointer or a hash table that maps each node to its parent.

4. Continue traversing the tree until you find the other node, keeping track of parent nodes along the way.

5. Create two sets: ancestors_a and ancestors_b. Add a and its ancestors to ancestors_a, and add b and its ancestors to ancestors_b.

6. Traverse up from a's ancestors towards the root of the tree. If you find an ancestor of a that is also in ancestors_b, that is the LCA.

7. If no ancestor of a is found in ancestors_b, traverse up from b's ancestors towards the root of the tree. If you find an ancestor of b
that is also in ancestors_a, that is the LCA.

8. If no common ancestor is found, then the root of the tree is the LCA.

 */
internal class TreeNode1(var `val`: Int) {
    var children: MutableList<TreeNode1> = ArrayList()

}
internal object Solution6 {
    fun lowestCommonAncestor(root: TreeNode1, a_: TreeNode1?, b_: TreeNode1?): Int {
        var a = a_
        var b = b_
        // In this algorithm, a stack is used to perform depth-first search traversal of the binary tree.
        // A deque (double-ended queue) is used as the implementation of the stack.
        // The reason for using a deque instead of a regular stack is that the ArrayDeque implementation in
        // Kotlin provides O(1) time complexity for both adding and removing elements from both the top and
        // bottom of the deque, while still maintaining the LIFO (last-in, first-out) ordering required for a stack.
        // This makes it a more efficient choice for implementing a stack in this algorithm.
        // Additionally, using a deque provides flexibility if the algorithm needs to be modified to use a different
        // traversal order (such as breadth-first search) in the future, as deque can easily switch between both FIFO
        // and LIFO ordering depending on the use case.
        val stack: Deque<TreeNode1> = ArrayDeque()
        val parent: MutableMap<TreeNode1?, TreeNode1?> = HashMap()
        parent[root] = null
        stack.push(root)

        //  traverse the binary tree until both nodes a and b are found and their parent nodes have been saved in the parent map.
        while (!parent.containsKey(a) || !parent.containsKey(b)) {
            val node = stack.pop()

            for (child in node.children) {
                parent[child] = node
                stack.push(child)
            }
        }
        //This loop iterates over the parent map, starting from a and working its way up to the root node.
        // During each iteration, the current node a is added to the ancestors set, and a is updated to its parent in the parent map.
        val ancestors: MutableSet<TreeNode1?> = HashSet()
        while (a != null) {
            ancestors.add(a)
            a = parent[a]
        }
        // The first ancestor of b which appears in
        // a's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(b)) b = parent[b]
        return b!!.`val`
    }
}
fun main() {
    // Driver Code
    val root = TreeNode1(1)
    root.children.add(TreeNode1(2))
    root.children.add(TreeNode1(3))
    root.children.add(TreeNode1(4))
    root.children[0].children.add(TreeNode1(5))
    root.children[0].children[0].children.add(TreeNode1(10))
    root.children[0].children.add(TreeNode1(6))
    root.children[0].children[1].children.add(TreeNode1(11))
    root.children[0].children[1].children.add(TreeNode1(12))
    root.children[0].children[1].children.add(TreeNode1(13))
    root.children[2].children.add(TreeNode1(7))
    root.children[2].children.add(TreeNode1(8))
    root.children[2].children.add(TreeNode1(9))
    val a = root.children[0].children[1].children[2]
    val b = root.children[0].children[0].children[0]
    val lca: Int = Solution6.lowestCommonAncestor(root, a, b)
    print("\"" + lca + "\"" + " is the lowest common ancestor of the nodes " + "\"" + a.`val` + "\"" + " and " + "\"" + b.`val` + "\"")
}

