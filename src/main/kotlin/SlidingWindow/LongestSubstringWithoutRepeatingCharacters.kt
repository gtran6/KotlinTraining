package SlidingWindow

fun findLongestSubstring(s: String) : Int {
    if (s.length < 2) return s.length
    var max = 1
    var start = 0
    val map = mutableMapOf<Char, Int>()
    var end = 0

    while (end < s.length) {
        val char = s[end]
        val prevIndex = map[char]

        if (prevIndex != null && prevIndex >= start) {
            val maxLen = end - start
            if (maxLen > max) {
                max = maxLen
            }
            start = prevIndex + 1
        } else if (end == s.length-1) {
            val maxLen = end - start + 1
            return if (max > maxLen) max else maxLen
        }
        map[char] = end
        end += 1
    }
    return max
}
fun main() {
    val s = "ABCDEDCBA"
    println(findLongestSubstring(s))
}
/*
1. Initialize an empty hash map and a variable to track character indices and the start of the window, respectively.

2. Traverse the string character by character. For each character, if the hashmap does not contain the current character,
store it with its index as the value.

3. If the hashmap contains the current character and its index falls within the current window, a repeating character is
found. Otherwise, store it in the hashmap with its index as the value.

4. When a repeating character is found, update the start of window to the previous location of the current element and
increment it. Also, calculate the length of the current window.

5. Update the longest substring seen so far if the length of the current window is greater than its current value.

6. Return the length of the longest substring.
 */