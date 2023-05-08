package FastAndSlowPointers

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var fast = head
    var slow = head

    for (i in 1..n) {
        fast = fast?.next
    }

    // If the fast pointer is null, this means that the node to be removed is the head node itself.
    if (fast == null) {
        return head?.next
    }

    // the fast and slow pointers are moved together until the fast pointer reaches the end of the list.
    while (fast?.next != null) {
        fast = fast?.next
        slow = slow?.next
    }

    // Once the fast pointer reaches the end of the list, the slow pointer points to the node that needs to be removed.
    slow?.next = slow?.next?.next
    return head
}
fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)
    var node = removeNthFromEnd(head, 2)
    while (node != null) {
        print(node.`val`)
        if (node.next != null) {
            print(" -> ")
        }
        node = node.next
    }
}