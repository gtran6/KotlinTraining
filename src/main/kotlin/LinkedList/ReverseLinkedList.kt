package LinkedList

class ListNode(var `val`: Int, var next: ListNode? = null)

fun reverseList(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    var curr: ListNode? = head
    var prev: ListNode? = null

    while (curr != null) {
        val nextNode = curr.next
        curr.next = prev
        prev = curr
        curr = nextNode
    }
    return prev
}
fun main() {
    // Create a linked list
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(5)

    // Print the original list
    var curr = head
    while (curr != null) {
        print("${curr.`val`} ")
        curr = curr.next!!
    }
    println() // Output: 1 2 3 4 5

    // Reverse the list
    val newHead = reverseList(head)

    // Print the reversed list
    curr = newHead!!
    while (curr != null) {
        print("${curr.`val`} ")
        curr = curr.next!!
    }
    println() // Output: 5 4 3 2 1
}
/*
- initialize 2 pointers: "curr" pointing to the head (value 1), "prev" pointing to null
- enter the loop that will traverse the list and reverse the pointers.
In the first iteration, curr points to the head node (which is the node with the value 1),
and prev points to null. The function stores the next node (which is the node with the value 2)
in a temporary variable nextNode, sets the next pointer of the current node to prev (which is null),
and updates the prev and curr pointers to point to the current node (which is the node with the value 1)
and the next node (which is the node with the value 2), respectively.
- after 1st iteration:
prev: 1 <- null
curr: 2 -> 3 -> 4 -> 5 -> null

In the second iteration, curr points to the node with the value 2, and prev points to the node with
the value 1. The function again stores the next node (which is the node with the value 3) in a temporary
variable nextNode, sets the next pointer of the current node (which is the node with the value 2) to prev
(which is the node with the value 1), and updates the prev and curr pointers to point to the current node
(which is the node with the value 2) and the next node (which is the node with the value 3), respectively.
- after 2sn iteration:
prev: 2 <- 1
curr: 3 -> 4 -> 5 -> null

The loop continues until curr is null, which happens after the last iteration when curr points to the node
with the value 5 and prev points to the node with the value 4. At this point, the pointers look like this:
prev: 5 <- 4 <- 3 <- 2 <- 1
curr: null

 */