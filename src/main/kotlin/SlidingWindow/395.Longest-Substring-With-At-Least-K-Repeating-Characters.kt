package SlidingWindow

fun longestSubstring(s: String, k: Int): Int {
    var maxLength = 0

    for (windowSize in s.length downTo k) {
        var left = 0
        var right = 0
        val charCounts = IntArray(26)
        var uniqueChars = 0
        var countAtLeastK = 0

        while (right < s.length) {
            if (uniqueChars <= windowSize) {
                val charIndex = s[right] - 'a'
                if (charCounts[charIndex] == 0) {
                    uniqueChars++
                }
                charCounts[charIndex]++
                if (charCounts[charIndex] == k) {
                    countAtLeastK++
                }
                right++
            } else {
                val charIndex = s[left] - 'a'
                if (charCounts[charIndex] == k) {
                    countAtLeastK--
                }
                charCounts[charIndex]--
                if (charCounts[charIndex] == 0) {
                    uniqueChars--
                }
                left++
            }

            if (uniqueChars == countAtLeastK) {
                maxLength = maxOf(maxLength, right - left)
            }
        }
    }

    return maxLength
}

fun main() {
    val s = "aaabb"
    val k = 3
    println(longestSubstring(s, k)) // 3: aaa
}