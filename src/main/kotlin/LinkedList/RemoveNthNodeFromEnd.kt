package LinkedList

fun removeNthFromEnd(head: ListNode?, n: Int) : ListNode? {
    var slow: ListNode? = null
    var fast = head
    var i = 1

    while (fast != null && i <= n) {
        fast = fast.next
        i++
    }
    while (fast != null) {
        slow = if (slow == null) head else slow.next //If it is null, we set slow to head; otherwise, we set it to slow.next.
        /*
        In this line of code, we are moving the slow pointer one node to the right. The new position
        of the slow pointer will depend on whether it was previously null or not.

        If slow is currently null, it means we are at the beginning of the linked list, so we want to
        move slow to the first node in the list. In this case, we set slow to head, which is the first node in the list.

        If slow is not null, it means we are somewhere in the middle of the linked list, so we want
        to move slow one node to the right. In this case, we set slow to slow.next, which is the next node in the list.
         */

        fast = fast.next
    }

    slow?.next = slow?.next?.next // remove node 4

    return if (slow == null) head?.next else head
}
fun main() {
    // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)

    // Remove the 2nd node from the end
    val newHead = removeNthFromEnd(head, 2)

    // Print the new linked list: 1 -> 2 -> 3 -> 5 -> null
    var curr = newHead
    while (curr != null) {
        print("${curr.`val`} -> ")
        curr = curr.next
    }
    println("null")
}
/*
Initialize slow to null, fast to the head of the linked list (i.e., node 1), and i to 1.

Traverse the list with the while loop, moving the fast pointer n nodes ahead of the slow pointer.
In this case, since n is 2, the fast pointer will move from node 1 to node 3.

Traverse the list again with the while loop, moving both the slow pointer and fast pointer together
until the fast pointer reaches the end of the list. This will result in the slow pointer being positioned
at the node just before the node to be removed (i.e., node 3), while the fast pointer is positioned at
the end of the list.

Remove the nth node from the end of the list by setting the next property of the node just before the
node to be removed (3 in this case) to the node just after the node to be removed (5 in this case).
This effectively removes the node with value 4 from the linked list.
 */