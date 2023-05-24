package Backtracking

fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) return emptyList()
    val res = mutableListOf<String>()
    val digitToLetters = arrayOf(
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    )
    backtrack8(digits, digitToLetters, res, 0, StringBuilder())
    return res
}

fun backtrack8(digits: String, digitToLetters: Array<String>, res: MutableList<String>, index: Int, string: StringBuilder) {
    if (index == digits.length) {
        res.add(string.toString())
        return
    }

    val digit = digits[index].toInt() - '0'.toInt()
    val letters = digitToLetters[digit]
    for (letter in letters) {
        string.append(letter)
        backtrack8(digits, digitToLetters, res, index+1, string)
        string.deleteCharAt(string.length - 1)
    }
}
fun main() {
    val digits = "23"
    println(letterCombinations(digits))
}
