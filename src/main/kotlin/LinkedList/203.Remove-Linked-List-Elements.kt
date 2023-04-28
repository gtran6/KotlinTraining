package LinkedList

fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    if (head == null) return null
    head.next = removeElements(head.next, `val`)
    return if (head.`val` == `val`) head.next else head
}