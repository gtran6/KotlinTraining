package leetcode

import java.util.*
import kotlin.collections.ArrayList

internal class TreeNode(var `val`: String) {
    var children: MutableList<TreeNode> = ArrayList()
}

internal object Solution5 {
    fun traverse(root: TreeNode?): List<List<String>> {
        val result:  MutableList<List<String>> = ArrayList()
        if (root == null) {
            return result
        }
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)

        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            val levelValues: MutableList<String> = ArrayList(levelSize)

            for (i in 0 until levelSize) {
                val node = queue.poll()
                // add the node of the current level
                levelValues.add(node.`val`)
                // add the children of current node in the queue
                queue.addAll(node.children)
            }
            result.add(levelValues)
        }
        return result
    }
}
fun main() {
    // Driver Code
    val root = TreeNode("body")
    root.children.add(TreeNode("div"))
    root.children.add(TreeNode("h1"))
    root.children.add(TreeNode("div"))
    root.children[0].children.add(TreeNode("h2"))
    root.children[0].children[0].children.add(TreeNode("ul"))
    root.children[0].children.add(TreeNode("h3"))
    root.children[0].children[1].children.add(TreeNode("a"))
    root.children[0].children[1].children.add(TreeNode("p"))
    root.children[0].children[1].children.add(TreeNode("table"))
    root.children[2].children.add(TreeNode("p"))
    root.children[2].children.add(TreeNode("a"))
    root.children[2].children.add(TreeNode("p"))
    val result: List<List<String>> = Solution5.traverse(root)
    println("Web nodes at each level: $result")
}