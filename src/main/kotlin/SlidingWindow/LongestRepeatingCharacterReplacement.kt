package SlidingWindow

// brute force
fun characterReplacement2(s: String, k: Int): Int {
    var maxLength = 0

    // Iterate over all possible substrings
    for (start in s.indices) {
        val freq = IntArray(26)
        var maxCount = 0

        for (end in start until s.length) {
            val c = s[end]
            freq[c - 'A']++
            maxCount = maxOf(maxCount, freq[c - 'A'])

            // Check if we can make at most k replacements to get a valid substring
            if (end - start + 1 - maxCount <= k) {
                maxLength = maxOf(maxLength, end - start + 1)
            }
        }
    }

    return maxLength
}

// sliding window with O(n)
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

        // Instead of checking all possible substrings, we move the start pointer of the
        // window when the condition (end - start + 1 - maxCount > k) is violated.
        // By doing so, we maintain a valid window of characters that can be formed
        // with at most k replacements.
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
    println(characterReplacement2(s, k))
}