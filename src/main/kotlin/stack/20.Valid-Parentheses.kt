package stack

import java.util.*

fun isValid(s: String): Boolean {
    if (s.isEmpty()) return true
    val stack = Stack<Char>()
    s.forEach { c ->
        if (c == '(') stack.push(')')
        else if (c == '[') stack.push(']')
        else if (c == '{') stack.push('}')
        else {
            if (stack.isEmpty() || stack.pop() != c) return false
        }
    }
    return stack.isEmpty()
}
fun main() {
    val s = "()[]{}["
    println(isValid(s))
}