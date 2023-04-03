package leetcode.Zoom

class Node(var `val`: String) {
    var leftChild: Node? = null
    var rightChild: Node? = null
    fun insert(`val`: String) {
        var current: Node? = this
        var parent: Node? = null
        while (current != null) {
            parent = current
            current =
                if (`val`.compareTo(current.`val`) < 0) current.leftChild else current.rightChild
        }
        if (`val`.compareTo(parent!!.`val`) < 0) parent.leftChild =
            Node(`val`) else parent.rightChild = Node(`val`)
    }
}