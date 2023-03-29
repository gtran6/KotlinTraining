package FastAndSlowPointers
/*
We’ll traverse the linked list using two pointers, where the slow pointer will move one step forward,
and the fast pointer will move two steps forward.

The slow pointer will reach the middle node of the linked list while the fast pointer will reach
the last node or NULL simultaneously.

We’ll get the middle node using the slow pointer and use it to reverse the second half of the linked list.

Then we will compare the original first half and the reverse second half of the linked list.

If both the halves are the same, then we’ll return TRUE. Otherwise, return FALSE.
 */

fun isPalindrome(head: ListNode?): Boolean {
    if (head?.next == null) return true
    //Initialize both the slow and fast pointers as head.
    var slow = head
    var fast = head

    //Traverse linked list using both pointers at different speeds. At each iteration,
    // the slow pointer increments by one node, and the fast pointer increments by two nodes.
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    // Continue doing so until the fast pointer reaches the end of the linked list.
    // At this instance, the slow pointer will be pointing at the middle of the linked list.

    // Reverse the second half of the linked list and compare it with the first half.
    var right: ListNode? = reverse(slow)
    var left = head

    while (right != null) {
        if (left!!.`val` != right.`val`) {
            return false
        }
        right = right.next
        left = left.next
    }

    return true
}
fun reverse(node: ListNode?) : ListNode? {
    var prev: ListNode? = null // Initialize a "prev" node to null
    var curr = node // Initialize a "curr" node to the head of the list
    while (curr != null) {
        val next = curr.next // Save a reference to the next node
        curr.next = prev
        prev = curr
        curr = next
    }
    return prev // Return the new head of the reversed list
}