package string

fun firstUniqChar(s: String): Int {
    val map = mutableMapOf<Char, Int>()
    for (c in s) {
        map[c] = map.getOrDefault(c, 0) + 1
    }
    for (i in s.indices) {
        if (map[s[i]] == 1) return i
    }
    return -1
}
fun main() {
    val s = "leetcode"
    println(firstUniqChar(s))
}