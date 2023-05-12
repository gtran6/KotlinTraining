package stack

import java.util.Stack

fun dailyTemperatures(temperatures: IntArray): IntArray {
    if (temperatures.size == 1) return intArrayOf(0)
    val res = IntArray(temperatures.size)
    val stack = Stack<Int>()
    var pop: Int
    for (i in temperatures.indices) {
        while (stack.isNotEmpty() && temperatures[stack.peek()] < temperatures[i]) {
            pop = stack.pop()
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