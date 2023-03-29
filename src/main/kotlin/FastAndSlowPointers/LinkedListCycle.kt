package FastAndSlowPointers

fun detectCycle(head: ListNode?) : Boolean {
    if (head == null) return false
    // initialize both slow and fast pointers to the head of the linked list
    var slow = head
    var fast = head

    while (fast?.next != null && fast.next!!.next != null) {
        // move slow pointer one node ahead
        // move fast pointer two nodes ahead
        slow = slow?.next
        fast = fast.next?.next
        // check if both pointers point to the same node
        if (slow == fast) return true
    }
    return false
}

class ListNode(val `val` : Int) {
    var next: ListNode? = null
}

fun main() {
    val head = ListNode(2)
    head.next = ListNode(4)
    head.next!!.next = ListNode(6)
    head.next!!.next!!.next = ListNode(8)
    head.next!!.next!!.next!!.next = ListNode(10)
    head.next!!.next!!.next!!.next!!.next = head.next
    println(detectCycle(head))
}
