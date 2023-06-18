package Backtracking

fun generateParenthesis(n: Int): List<String> {
    val res = mutableListOf<String>()
    backtrack(n, res, 0, 0, "")
    return res
}
fun backtrack(n: Int, res: MutableList<String>, open: Int, close: Int, current: String) {
    if (current.length == n*2) {
        res.add(current)
        return
    }
    if (open < n) {
        backtrack(n, res, open+1, close, "$current(")
    }
    if (close < open) {
        backtrack(n, res, open, close+1, "$current)")
    }
}
fun main() {
    val n = 3
    println(generateParenthesis(n))
}