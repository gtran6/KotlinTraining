package string

fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()
    s.forEach {
        when (it) {
            '(' -> stack.add(')')
            '{' -> stack.add('}')
            '[' -> stack.add(']')
            else -> if (stack.isEmpty() || stack.removeLast() != it) return false
        }
    }
    return stack.isEmpty()
}