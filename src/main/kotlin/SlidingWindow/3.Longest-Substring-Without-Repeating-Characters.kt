package SlidingWindow

fun lengthOfLongestSubstring(s: String): Int {
    var maxLen = 0
    var start = 0
    var end = 0
    val set = HashSet<Char>()

    while (end < s.length) {
        if (!set.contains(s[end])) {
            set.add(s[end])
            maxLen = maxOf(maxLen, end - start + 1)
            end++
        } else {
            set.remove(s[start])
            start++
        }
    }
    return maxLen
}
fun main() {
    val s = "abcabcbb"
    println(lengthOfLongestSubstring(s))
}