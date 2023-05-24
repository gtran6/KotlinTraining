package Backtracking

fun partition(s: String): List<List<String>> {
    val res = mutableListOf<List<String>>()
    backtrack9(s, res, 0, mutableListOf())
    return res
}

fun backtrack9(s: String, res: MutableList<List<String>>, index: Int, list: MutableList<String>) {
    if (index == s.length) {
        res.add(list.toList())
        return
    }
    for (i in index until s.length) {
        val substring = s.substring(index, i + 1)
        if (checkPalindrome(substring)) {
            list.add(substring)
            backtrack9(s, res, i + 1, list)
            list.removeAt(list.size - 1)
        }
    }

}

fun checkPalindrome(s: String): Boolean {
    var left = 0
    var right = s.length - 1

    while (left < right) {
        if (s[left] != s[right]) {
            return false
        }
        left++
        right--
    }

    return true
}
fun main() {
    val s = "aab"
    println(partition(s))
}
