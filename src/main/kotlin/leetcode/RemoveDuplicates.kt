package leetcode

import java.util.*

fun removeDuplicates2(s: String): String {
    // create an empty stack to hold characters
    val stack = Stack<Char>()
    // iterate over each character in the input string
    s.forEach { c ->
        // check if the stack is not empty and the top element is equal to the current character
        if (stack.isNotEmpty() && stack.peek() == c) {
            // if so, remove the top element from the stack
            stack.pop()
        } else {
            // if not, push the current character onto the stack
            stack.push(c)
        }
    }
    // convert the stack to a string and return it
    return stack.joinToString("")
}

fun main() {
    println(removeDuplicates2("sammmaddkkkdasa"))
}
