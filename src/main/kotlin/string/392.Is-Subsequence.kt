package string

fun isSubsequence(s: String, t: String): Boolean {
    var i = 0
    for (j in t.indices) {
        if (i == s.length) return true
        if (s[i] == t[j]) i++
    }
    return i == s.length
}
fun main() {
    val s = "abc"
    val t = "ahbgdc"
    println(isSubsequence(s, t))
}