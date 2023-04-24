package LinkedList

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var l1 = list1
    var l2 = list2
    val dummyHead = ListNode(0)
    var tail = dummyHead

    while (l1 != null && l2 != null) {
        if (l1.`val` < l2.`val`) {
            tail.next = l1
            l1 = l1.next
        } else {
            tail.next = l2
            l2 = l2.next
        }
        tail = tail.next!!
    }
    tail.next = l1 ?: l2
    return dummyHead
}