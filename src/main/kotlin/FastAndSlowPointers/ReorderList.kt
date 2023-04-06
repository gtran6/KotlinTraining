package FastAndSlowPointers

fun reorderList(head: ListNode?): Unit {
    if (head?.next == null) return

    var slow = head
    var fast = head.next

    while (fast?.next != null && slow != null) {
        fast = fast.next!!.next
        slow = slow.next
    }

    var reversed = reverse(slow!!.next)
    slow.next = null
    var curr = head

    while (curr != null && reversed != null) {
        val next = curr.next
        val revNext = reversed.next
        curr.next = reversed
        reversed.next = next
        curr = next
        reversed = revNext
    }
}