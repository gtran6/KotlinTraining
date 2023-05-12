package stack

fun generateParenthesis(n: Int): List<String> {
    val res = mutableListOf<String>()
    backtrack5(n, res, 0, 0, "")
    return res
}

fun backtrack5(n: Int, res: MutableList<String>, open: Int, close: Int, current: String) {
    if (current.length == n*2) {
        res.add(current)
        return
    }

    /*
    If the current string is not yet of the desired length, we check if we can add an open
    parenthesis (i.e., if the current number of open parentheses is less than n). If we can,
    we call backtrack again with the string concatenated with an open parenthesis, and with
    the number of open parentheses incremented by 1.
     */
    if (open < n) {
        backtrack5(n, res, open+1, close, "$current(")
    }

    /*
    If the current number of closed parentheses is less than the current number of open parentheses,
    we call backtrack with the string concatenated with a closed parenthesis, and with the number
    of closed parentheses incremented by 1.
     */
    if (close < open) {
        backtrack5(n, res, open, close+1, "$current)")
    }
}
fun main() {
    val n = 4
    println(generateParenthesis(n))
}



