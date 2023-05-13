package stack

import java.util.Stack

// brute force T: O(n^2)
fun dailyTemperatures(temperatures: IntArray): IntArray {
    val res = IntArray(temperatures.size)
    for (i in temperatures.indices) {
        for (j in i+1 until temperatures.size) {
            if (temperatures[j] > temperatures[i]) {
                res[i] = j - i
                break
            }
        }
    }
    return res
}
// stack T: O(n), S: O(n)
fun dailyTemperatures1(temperatures: IntArray): IntArray {
    if (temperatures.size == 1) return intArrayOf(0)
    val res = IntArray(temperatures.size)
    val stack = Stack<Int>()
    for (i in temperatures.indices) {
        while (stack.isNotEmpty() && temperatures[stack.peek()] < temperatures[i]) {
            val pop = stack.pop()
            res[pop] = i - pop
        }
        stack.push(i)
    }
    return res
}
fun main() {
    val temperatures = intArrayOf(73,74,75,71,69,72,76,73)
    println(dailyTemperatures(temperatures).contentToString())
}
/*
[1,1,0,0,1,1,0,0] -> [1,1,4,2,1,1,0,0]
 */
/*
Stacks are particularly useful in solving problems that involve processing elements in a Last-In-First-Out (LIFO) order.
Some common types of problems that can be solved using a stack-based approach include:

Parentheses matching and balancing problems
Infix, prefix, and postfix notation problems
Backtracking problems
Tree and graph traversal problems
Depth-First Search (DFS) problems
Conversion problems, such as converting a decimal number to binary or converting an infix expression to postfix notation.

In general, any problem that requires tracking and manipulating a set of elements in a LIFO order can be a good candidate for a stack-based approach.
 */