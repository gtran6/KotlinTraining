package Trees

class Node2(var `val`: Int) {
    var left: Node2? = null
    var right: Node2? = null
    var next: Node2? = null
}

fun connect(root: Node2?): Node2? {
    if (root == null) return null

    var levelStart: Node2 = root
    while (levelStart != null) {
        var curr: Node2? = levelStart
        var dummy = Node2(0)
        var prev: Node2? = dummy

        while (curr != null) {
            if (curr.left != null) {
                prev?.next = curr.left
                prev = curr.left
            }

            if (curr.right != null) {
                prev?.next = curr.right
                prev = curr.right
            }
            curr = curr.next
        }
        levelStart = dummy?.next!!
    }
    return root
}