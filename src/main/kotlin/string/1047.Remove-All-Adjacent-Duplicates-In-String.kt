package string

import java.util.Stack

fun removeDuplicates(s: String): String {
    if (s.isEmpty()) return ""
    val stack = Stack<Char>()
    s.forEach { c ->
        if (stack.isNotEmpty() && stack.last() == c) {
            stack.pop()
        } else {
            stack.push(c)
        }
    }
    return stack.joinToString("")


/*    shouldn't use ArrayDeque for this prob
    The problem with this implementation is that the removeLast() method used to remove the last element
    from the stack has a time complexity of O(1) in the average case, but in the worst case, when the stack
    is full, it can take O(n) time to resize the underlying array. Since this function is called repeatedly
    on a large number of inputs, this resizing operation can cause the function to exceed the time limit.

    if (s.isEmpty()) return ""
    val stack = ArrayDeque<Char>()
    s.forEach { c ->
        if (stack.isNotEmpty() && stack.last() == c) {
            stack.removeLast()
        } else {
            stack.add(c)
        }
    }
    return stack.joinToString("")*/

}
fun main() {
    val s = "abbaca"
    println(removeDuplicates(s))
}