package FastAndSlowPointers
/*
We initialize both slow and fast pointers as the head.

We traverse the linked list using both pointers, where the slow pointer will move one step forward,
and the fast pointer will move two steps forward.

When the fast pointer points reaches the end of the linked list, that is, it becomes equal to NULL;
the slow pointer will simultaneously point to the middle node. Therefore, we return the slow pointer.
 */

fun middleNode(head: ListNode?): ListNode? {
    if (head == null) return null
    var slow = head
    var fast = head
    while (fast?.next != null) {
        slow = slow!!.next
        fast = fast.next!!.next
    }
    return slow
}
fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(6)
    println(middleNode(head))
}