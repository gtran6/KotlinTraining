package SlidingWindow

fun characterReplacement(s: String, k: Int): Int {
    // freq is used to keep track of the frequency of each letter in the current window.
    val freq = IntArray(26)
    // stores the frequency of the most common letter in the window
    var maxCount = 0
    var maxLength = 0
    var start = 0

    for (end in s.indices) {
        val c = s[end]
        freq[c - 'A']++
        // update maxCount to the max frequency seen so far
        maxCount = maxOf(maxCount, freq[c - 'A'])

        while (end - start + 1 - maxCount > k) {
            freq[s[start] - 'A']--
            start++
        }
        maxLength = maxOf(maxLength, end - start + 1)
    }
    return maxLength
}
fun main() {
    val s = "ABAB"
    val k = 2
    println(characterReplacement(s, k))
}