package TwoPointers

import java.util.*

fun backspaceCompare1(s: String, t: String): Boolean {
    return build(s) == build(t)
}
fun build(s: String) : String {
    val stack = Stack<Char>()
    for (c in s) {
        if (stack.isNotEmpty() && c == '#') {
            stack.pop()
        } else if (c != '#') {
            stack.push(c)
        }
    }
    val sb = StringBuilder()
    for (c in stack) {
        sb.append(c)
    }
    return sb.toString()
}

fun backspaceCompare(s: String, t: String): Boolean {
    fun applyBackspaces(str: String): String {
        val sb = StringBuilder()
        for (c in str) {
            if (c == '#') {
                if (sb.isNotEmpty()) sb.deleteCharAt(sb.length - 1)
            } else {
                sb.append(c)
            }
        }
        return sb.toString()
    }
    return applyBackspaces(s) == applyBackspaces(t)
}
fun main() {
    val s = "a#c"
    val t = "b"
    println(backspaceCompare1(s, t))
}