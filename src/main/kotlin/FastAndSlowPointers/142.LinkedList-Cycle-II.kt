package FastAndSlowPointers

fun detectCycleII(head: ListNode?): ListNode? {
    if (head == null) return null
    var slow = head
    var fast = head

    while (fast?.next != null ) {
        slow = slow?.next
        fast = fast.next?.next

        if (slow == fast) {
            var p1 = head
            var p2 = slow

            while (p1 != p2) {
                p1 = p1?.next
                p2 = p2?.next
            }
            return p1
        }
    }
    return null
}