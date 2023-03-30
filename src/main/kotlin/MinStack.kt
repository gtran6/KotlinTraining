import java.util.*

class MinStack {
    val minStack = LinkedList<Int>()
    val stack = LinkedList<Int>()

    fun push(x: Int) {
        stack.add(x)
        if (minStack.isEmpty() || x <= minStack.last())
            minStack.add(x)
    }
    fun pop() {
        if (stack.isNotEmpty()) {
            val last = stack.removeLast()
            if (last == minStack.last())
                minStack.removeLast()
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