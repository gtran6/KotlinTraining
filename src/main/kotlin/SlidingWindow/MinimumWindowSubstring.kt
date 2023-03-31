package SlidingWindow

fun minWindow2(s: String, t: String): String {
    if (s.isEmpty() || s.length < t.length) return ""

    val map = hashMapOf<Char, Int>()
    for (i in t.indices) map[t[i]] = map.getOrDefault(t[i], 0) + 1

    var start = 0
    var end = 0
    var minLeft = Integer.MAX_VALUE
    var minLen = Integer.MAX_VALUE
    var count = t.length

    while (end < s.length) {
        var ch = s[end]
        if (map.containsKey(ch)) {
            map[ch] = map[ch]!! - 1
            if (map[ch]!! >= 0) count--
        }
        while (count == 0) {
            if (end - start + 1 < minLen) {
                minLeft = start
                minLen = end - start + 1
            }
            ch = s[start]
            if (map.containsKey(ch)) {
                map[ch] = map[ch]!! + 1
                if (map[ch]!! > 0) count++
            }
            start++
        }
        end++
    }

    if (minLen > s.length) return ""
    return s.substring(minLeft, minLeft + minLen)
}

fun main() {
    val s = "ADOBECODEBANC"
    val t = "ABC"
    println(minWindow2(s, t))
}