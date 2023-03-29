class MinStack {
    val minStack = mutableListOf<Int>()
    val stack = mutableListOf<Int>()

    fun push(x: Int) {
        stack.add(x)
        if (minStack.isEmpty() || x <= minStack.last())
            minStack.add(x)
    }
    fun pop(x: Int) {
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