package stack

import java.util.LinkedList

class MinStack {
    val stack = LinkedList<Int>()
    //use an additional stack to keep track of the minimums every time a new element is added to the stack.
    val minStack = LinkedList<Int>()

    fun push(`val`: Int) {
        stack.add(`val`)
        if (minStack.isEmpty() || `val` <= minStack.last()) {
            minStack.add(`val`)
        }
    }

    fun pop() {
        if (stack.isNotEmpty()) {
            val top = stack.removeLast()
            if (top == minStack.last()) {
                minStack.removeLast()
            }
        }
    }

    fun top() : Int {
        if (stack.isNotEmpty()) {
            return stack.last()
        }
        return 0
    }

    fun getMin() : Int {
        if (minStack.isNotEmpty()) {
            return minStack.last()
        }
        return 0
    }
}