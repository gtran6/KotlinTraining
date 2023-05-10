package Backtracking

fun letterCasePermutation(s: String): List<String> {
    val res = mutableListOf<String>()
    backtrack4(s, res, 0, mutableListOf<String>())
    return res
}

fun backtrack4(s: String, res: MutableList<String>, index: Int, list: MutableList<String>) {
    if (list.size == s.length) {
        res.add(list.joinToString(""))
        return
    }

    (index until s.length).forEach { i ->
        if (s[i].isLetter()) {
            list.add(s[i].toString().uppercase())
            backtrack4(s, res, i+1, list)
            list.removeAt(list.size-1)
            list.add(s[i].toString().lowercase())
            backtrack4(s, res, i+1, list)
            list.removeAt(list.size-1)
        } else {
            list.add(s[i].toString())
            backtrack4(s, res, i+1, list)
            list.removeAt(list.size-1)
        }
    }
}
fun main() {
    val s = "a1b2"
    println(letterCasePermutation(s))
}
