package LinkedList
/*
we use a sentinel node to simplify the logic of the algorithm.
We also keep track of the last distinct node using the lastDistinct variable,
which is initialized to the sentinel node. Whenever we encounter a node with a
duplicate value, we skip over it and its duplicates using a while loop.
Finally, we update the last distinct node's next pointer to remove any
duplicates that might be left.
 */
fun deleteDuplicates1(head: ListNode?): ListNode? {
    val sentinel = ListNode(-1)
    sentinel.next = head
    var lastDistinct: ListNode? = sentinel
    var current = head

    while (current != null) {
        // if it's a beginning of duplicates sublist
        // skip all duplicates
        if (current.next != null && current.next?.`val` == current.`val`) {
            // move till the end of duplicates sublist
            while (current?.next != null && current?.next?.`val` == current?.`val`) {
                current = current?.next
            }
            // skip all duplicates
            lastDistinct?.next = current?.next
        // otherwise, move lastDistinct
        } else {
            lastDistinct = current
        }
        // move forward
        current = current?.next
    }
    return sentinel.next
}