package leetcode.Netflix

fun isAnagram(s: String, t: String): Boolean {
    var i = s.toCharArray().sorted()
    var j = t.toCharArray().sorted()

    return i == j
}
fun main() {
    val s = "anagrdm"
    val t = "nagaram"
    println(isAnagram(s, t))
}