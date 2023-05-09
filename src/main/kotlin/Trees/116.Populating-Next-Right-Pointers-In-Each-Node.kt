package Trees

import java.util.*

class Node1(var `val`: Int) {
         var left: Node1? = null
         var right: Node1? = null
         var next: Node1? = null
}
fun connect(root: Node1?): Node1? {
    if (root == null) return null

    var levelStart = root

    while (levelStart?.left != null ) {
        var curr = levelStart

        while (curr != null) {
            // first set the next pointer of the left child to the right child
            curr.left?.next = curr.right

            //then check if curr has a next node, and if it does, we set the next pointer of the right child to the left child of the next node.
            if (curr.next != null) {
                curr.right?.next = curr.next?.left
            }
            curr = curr.next
        }
        //update levelStart to its left child, since we have now populated all the next pointers for the current level.
        levelStart = levelStart.left
    }
    return root
}

fun connect2(root: Node1?): Node1? {
    if (root == null) return null

    val queue = LinkedList<Node1>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        var prev: Node1? = null

        for (i in 0 until queue.size) {
            val curr = queue.poll()

            if (prev != null) {
                prev.next = curr
            }
            prev = curr

            if (curr.left != null) {
                queue.offer(curr.left)
            }
            if (curr.right != null) {
                queue.offer(curr.right)
            }
        }
    }
    return root
}