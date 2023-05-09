package LinkedList

class MyLinkedList() {

    class Node(val value: Int, var next: Node? = null)

    var head: Node? = null
    var size = 0

    fun get(index: Int): Int {
        if (index < 0 || index >= size) return -1
        var curr = head
        repeat(index) {
            curr = curr?.next
        }
        return curr!!.value
    }

    fun addAtHead(`val`: Int) {
        head = Node(`val`, head)
        size++
    }

    fun addAtTail(`val`: Int) {
        if (size == 0) {
            addAtHead(`val`)
        } else {
            var curr = head
            repeat(size - 1) {
                curr = curr?.next
            }
            curr?.next = Node(`val`)
            size++
        }
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if (index < 0 || index > size) return
        if (index == 0) {
            addAtHead(`val`)
        } else if (index == size) {
            addAtTail(`val`)
        } else {
            var curr = head
            repeat(index - 1) {
                curr = curr?.next
            }
            curr?.next = Node(`val`, curr?.next)
            size++
        }
    }

    fun deleteAtIndex(index: Int) {
        if (index < 0 || index > size) return
        if (index == 0) {
            head = head?.next
            size--
        } else {
            var curr = head
            repeat(index - 1) {
                curr = curr?.next
            }
            curr?.next = curr?.next?.next
            size--
        }
    }

}