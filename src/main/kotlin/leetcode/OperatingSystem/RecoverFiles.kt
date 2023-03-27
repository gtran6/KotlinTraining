package leetcode.OperatingSystem

data class StackEntry(val index: Int, val char : Char)

fun recoverFiles(s: String): String {
    val stack = ArrayDeque<StackEntry>()
    for (i in s.indices)
        // if the current character is a closing parenthesis and the top of the stack is an opening parenthesis,
        // then remove the opening parenthesis from the stack as it has been matched with the current close parenthesis
        if (!stack.isEmpty() && stack.first().char == '(' && s[i] == ')')
            stack.removeFirst()
        else if (s[i] == '(' || s[i] == ')') {
            // if the current character is an opening or closing parenthesis, add it to the stack along with its index
            val tmp = StackEntry(i, s[i])
            stack.addFirst(tmp)
        }
    /*
    After iterating through the string, we can loop through it again in reverse order to recover the files.
    For each character, if its index matches the index of an unmatched opening parenthesis in the stack, then
    remove the opening parenthesis from the stack and increment the count of unmatched parentheses.
    Otherwise, add the character to the result string.
     */
    var res = ""
    var count = 0
    for (i in s.length-1 downTo 0) {
        if (!stack.isEmpty() && stack.first().index == i) {
            stack.removeFirst()
            count++
        } else {
            res += s[i]
        }
    }
    return res.reversed()
}
fun main() {
    val s = "11)01(110)001("
    println(recoverFiles(s))
}