package StackQueue

import java.util.EmptyStackException
import java.util.Stack

private val stack1 = Stack<Int>()
private val stack2 = Stack<Int>()

fun push(x: Int) {
    // move all elements from stack 2 to stack 1
    while (!stack2.isEmpty()) {
        stack1.push(stack2.pop())
    }
    stack1.push(x)
}

fun pop(): Int {
    // move all elements from stack 1 to stack 2
    while (!stack1.isEmpty()) {
        stack2.push(stack1.pop())
    }
    // Pop the top element from stack2 (which was originally at the bottom of stack1)
    if (stack2.isEmpty()) {
        throw EmptyStackException()
    }
    return stack2.pop()
}

fun peek(): Int {
    // move all elements from stack 1 to stack 2
    while (!stack1.isEmpty()) {
        stack2.push(stack1.pop())
    }
    // Peek at the top element of stack2 (which was originally at the bottom of stack1)
    if (stack2.isEmpty()) {
        throw EmptyStackException()
    }
    return stack2.peek()
}

fun empty(): Boolean {
    return stack1.isEmpty() && stack2.isEmpty()
}

// queue 1  2  3
// stack1 3 2
// stack2 1