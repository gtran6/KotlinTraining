package leetcode

import java.util.*
import kotlin.collections.ArrayDeque

//By using a data class, we can easily create new stackEntry objects to represent each character
// in the input string with its consecutive count, and easily access or modify their properties as needed.
data class stackEntry(val character: Char, var count: Int = 1)
fun removeDuplicates(str: String, k: Int): String {
    // create a stack to keep track of characters
    //ArrayDeque is a class in Kotlin that implements a double-ended queue (deque) data structure backed by an array.
    // It provides constant time amortized operations for adding or removing elements at the beginning or the end of the deque.
    //By creating an ArrayDeque of stackEntry objects, we can push new stackEntry objects onto the top of the stack
    // using the push method, and pop the most recent stackEntry object off the top of the stack using the pop method.
    // This allows us to keep track of the consecutive counts of characters in the input string as we iterate over it,
    // and remove substrings of length k as needed.
    var stack = ArrayDeque<stackEntry>()
    for (char in str) {
        if (stack.isNotEmpty() && stack.last().character == char) {
            stack.last().count++
            if (stack.last().count == k) {
                stack.removeLast()
            }
        } else {
            stack.addLast(stackEntry(char))
        }
    }
    var result = ""
    while(!stack.isEmpty())
    {
        var e = stack.removeFirst()
        result += e.character.toString().repeat(e.count)
    }
    return result
}

fun removeDuplicates2(s: String, k: Int): String {
    val stack: Stack<Pair<Char, Int>> = Stack()

    for (ch: Char in s) {
        if (stack.isNotEmpty() && stack.peek().first == ch) {
            stack.push(Pair(ch, stack.peek().second + 1))
        } else {
            stack.push(Pair(ch, 1))
        }

        if (stack.peek().second == k) {
            for (i in 1..k) stack.pop()
        }
    }

    var ans: String = ""
    for (value: Pair<Char, Int> in stack) ans = ans + value.first
    return ans
}

fun main() {
    println(removeDuplicates("sammmaddkkkdasa", 3))
}