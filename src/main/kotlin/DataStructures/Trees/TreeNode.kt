package DataStructures.Trees

import DataStructures.Queue

class TreeNode<T>(val value: T) {
    private val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) = children.add(child)

    // Depth-First Traversal: Depth-first traversal starts at the root node
    // and explores the tree as far as possible along each branch before
    // reaching a leaf and then backtracking.
    fun forEachDepthFirst(visit: Visitor<T>) {
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }

    // Level-Order Traversal: Level-order traversal is a technique that
    // visits each node of the tree based on the depth of the nodes.
    // Starting at the root, every node on a level is visited before going to a lower level.
    fun forEachLevelOrder(visit: Visitor<T>) {
        visit(this)

    }
}

typealias Visitor<T> = (TreeNode<T>) -> Unit