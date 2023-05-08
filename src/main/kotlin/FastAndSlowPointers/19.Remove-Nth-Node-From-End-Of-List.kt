package FastAndSlowPointers

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var fast = head
    var slow = head

    for (i in 1..n) {
        fast = fast?.next
    }

    if (fast == null) {
        return head?.next
    }

    while (fast?.next != null) {
        fast = fast?.next
        slow = slow?.next
    }

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