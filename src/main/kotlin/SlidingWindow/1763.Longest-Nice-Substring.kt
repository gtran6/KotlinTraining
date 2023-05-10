package SlidingWindow

// brute force with O(n^2)
fun longestNiceSubstring(s: String): String {
    if (s.length <= 1) return ""

    var longestNiceSubstring = ""
    for (i in s.indices) {
        for (j in i + 1 until s.length) {
            val substring = s.substring(i, j + 1)
            if (substring.all { c -> substring.contains(c.lowercaseChar()) && substring.contains(c.uppercaseChar()) }) {
                if (substring.length > longestNiceSubstring.length) {
                    longestNiceSubstring = substring
                }
            }
        }
    }
    return longestNiceSubstring
}

// divide and conquer with O(n)
fun longestNiceSubstring1(s: String): String {
    if (s.length <= 1) return ""

    for (i in s.indices) {
        val c = s[i]

        if (s.contains(c.uppercaseChar()) && s.contains(c.lowercaseChar())) {
            continue
        }
        val left = longestNiceSubstring1(s.substring(0, i))
        val right = longestNiceSubstring1(s.substring(i+1))
        return if (left.length >= right.length) left else right
    }
    return s
}
fun main() {
    val s = "YazaAay"
    println(longestNiceSubstring1(s))
}