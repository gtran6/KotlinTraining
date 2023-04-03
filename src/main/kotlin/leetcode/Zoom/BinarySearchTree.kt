package leetcode.Zoom

class BinarySearchTree {
    var root: Node? = null
    fun insert(`val`: String) {
        if (root == null) root = Node(`val`) else this.root!!.insert(`val`)
    }
}