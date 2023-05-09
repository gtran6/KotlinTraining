package LinkedList

import java.util.PriorityQueue

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val dummy = ListNode(0)
    var tail: ListNode? = dummy

    //we create a PriorityQueue with a comparator that compares the val field of ListNodes.
    val queue = PriorityQueue<ListNode>(compareBy { it.`val` })

    // loop through the input array of linked lists and add each non-null list to the priority queue.
    for (list in lists) {
        if (list != null) {
            queue.offer(list)
        }
    }

    // We then repeatedly extract the smallest node from the priority queue, add it to the result list,
    while (queue.isNotEmpty()) {
        val node = queue.poll()
        tail?.next = node
        tail = tail?.next

        // add the next node from its original list to the priority queue if there is one.
        if (node.next != null) {
            queue.offer(node.next)
        }
    }
    //return the next field of the dummy node as the head of the merged linked list.
    return dummy.next
}
/*

The time complexity for our solution is O(N log K) where N - is a total number of nodes in all lists where K -
is a number of sorted linked lists we have.

The space complexity for our solution is O(N) where N - is total number of nodes to create an answer plus O(K)
where K - is number of sorted linked lists we have. According to the big O notation we can omit O(K) because it
could be equal or less than O(N) in terms of a number of elements.

 */