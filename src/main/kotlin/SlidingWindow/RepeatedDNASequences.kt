package SlidingWindow

fun findRepeatedDnaSequences(s: String): List<String> {
    val map = mutableMapOf<String, Int>()
    var left = 0
    var right = 9
    val result = mutableSetOf<String>()

    while (right < s.length) {
        val substring = s.substring(left, right+1)
        map.put(substring, map.getOrDefault(substring, 0) + 1)

        if (map.getOrDefault(substring, 0) >= 2) {
            result.add(substring)
        }
        left++
        right++
    }
    return result.toList()
}
fun main() {
    val s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
    println(findRepeatedDnaSequences(s))
}