package DataStructures

data class Node<T> (var value: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            ("value -> ${next.toString()}")
        } else {
            "$value"
        }
    }
}

fun main() {
    val node1 = Node(value = 1)
    val node2 = Node(value = 2)
    val node3 = Node(value = 3)
    node1.next = node2
    node2.next = node3
    //println(node1)

    val list = LinkedList<Int>()
    list.push(3)
    list.push(2)
    list.push(1)
//    println(list)

//    list.append(1)
//    list.append(2)
//    list.append(3)
//    println(list)


//    println("Before inserting: $list")
//    var middleNode = list.nodeAt(1)!!
//    for (i in 1..3) {
//        middleNode = list.insert(-1 * i, middleNode)
//    }
//    println("after inserting: $list")

//    list.push(3)
//    list.push(2)
//    list.push(1)
//    println("before popping list: ${list}")
//    val poppedValue = list.pop()
//    println("after popping list: ${list}")
//    println("popped value: ${poppedValue}")


//    println("Before removing last node: ${list}")
//    val removedValue = list.removeLast()
//    println("after removing last node: ${list}")
//    println("removed value: ${removedValue}")

    println("Before removing at particular index: $list")
    val index = 1
    val node = list.nodeAt(index - 1)!!
    val removedValue = list.removeAfter(node)
    println("After removing at index $index: $list")
    println("Removed value: $removedValue")

}
 class LinkedList<T> {
     private var head: Node<T>? = null
     private var tail: Node<T>? = null
     private var size = 0
     fun isEmpty(): Boolean {
         return false
     }

     override fun toString(): String {
         if (isEmpty()) {
             return "Empty list"
         } else {
             return head.toString()
         }
     }
     //push: Adds a value at the front of the list.
     fun push(value: T) {
         head = Node(value = value, next = head)
         if (tail == null) {
             tail = head
         }
         size++
     }

     //append: Adds a value at the end of the list.
     fun append(value: T) {
         if (isEmpty()) {
             push(value)
             return
         }
         tail?.next = Node(value = value)
         tail = tail?.next
         size++
     }

     // insert
     // 1. Finding a particular node in the list.
     // 2. Inserting the new node after that node.
     fun nodeAt(index: Int): Node<T>? {
         var currentNode = head
         var currentIndex = 0
         while (currentNode != null && currentIndex < index) {
             currentNode = currentNode.next
             currentIndex++
         }
         return currentNode
     }
     fun insert(value: T, afterNode: Node<T>): Node<T> {
         if (tail == afterNode) {
             append(value)
             return tail!!
         }
         val newNode = Node(value = value, next = afterNode.next)
         afterNode.next = newNode
         size++
         return newNode
     }

     // pop: Removes the value at the front of the list.
     fun pop(): T? {
         if (!isEmpty()) size--
         val result = head?.value
         head = head?.next
         if (isEmpty()) {
             tail = null
         }
         return result
     }

     // removeLast: removes the value at the end of the list
     fun removeLast(): T? {
         val head = head ?: return null
         if (head.next == null) return pop()
         size--

         var prev = head
         var current = head
         var next = current.next

         while (next != null) {
             prev = current
             current = next
             next = current.next
         }
         prev.next = null
         tail = prev
         return current.value
     }

     // removeAfter: removes a value anywhere in the list
     fun removeAfter(node: Node<T>): T? {
         val result = node.next?.value
         if (node.next == tail) {
             tail = node
         }
         if (node.next != null) {
             size--
         }
         node.next = node.next?.next
         return result
     }
 }
