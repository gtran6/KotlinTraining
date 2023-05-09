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
        when (size) {
            0 -> {
                addAtHead(`val`)
            }
            else -> {
                var curr = head
                repeat(size - 1) {
                    curr = curr?.next
                }
                curr?.next = Node(`val`)
                size++
            }
        }
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if (index < 0 || index > size) return
        when (index) {
            0 -> {
                addAtHead(`val`)
            }
            size -> {
                addAtTail(`val`)
            }
            else -> {
                var curr = head
                repeat(index - 1) {
                    curr = curr?.next
                }
                curr?.next = Node(`val`, curr?.next)
                size++
            }
        }
    }

    fun deleteAtIndex(index: Int) {
        when {
            size == 0 || index > size - 1 || index < 0 -> return
            index == 0 -> head = head?.next
            else -> findAtIndex(index - 1)?.let {
                it.next = it.next?.next
            }
        }
        size--
    }

    private fun findAtIndex(index: Int): Node? =
        when {
            size == 0 || index > size - 1 -> null
            index <= 0 -> head
            else -> {
                var next = head?.next
                repeat(index - 1) {
                    next = next?.next
                }
                next
            }
        }
}