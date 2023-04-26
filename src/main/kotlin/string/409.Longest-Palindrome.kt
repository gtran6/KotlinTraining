package string

fun longestPalindrome(s: String): Int {
    val map = mutableMapOf<Char, Int>()
    for (c in s) {
        map[c] = map.getOrDefault(c, 0) + 1
    }
    var count = 0
    map.values.forEach {
        count += it % 2
    }
    return if (count > 1) {
        s.length - count + 1
    } else {
        s.length
    }
}
fun main() {
    val s = "abccccdd"
    println(longestPalindrome(s))
}