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