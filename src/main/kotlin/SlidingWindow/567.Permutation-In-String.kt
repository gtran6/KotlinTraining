package SlidingWindow

fun checkInclusion(s1: String, s2: String): Boolean {
    val s1Counts = IntArray(26)
    val s2Counts = IntArray(26)

    for (c in s1) {
        s1Counts[c - 'a']++
    }

    s2.indices.forEach { i ->
        s2Counts[s2[i] - 'a']++

        // sliding window
        if (i >= s1.length) {
            s2Counts[s2[i - s1.length] - 'a']--
        }

        if (s1Counts.contentEquals(s2Counts)) {
            return true
        }
    }
    return false
}

fun main() {
    val s1 = "ab"
    val s2 = "eidbaooo"
    println(checkInclusion(s1, s2))
}
/*
We iterate through each index i in s2 using s2.indices.forEach, and perform the following steps:

1. Increment the count of the current character in s2Counts, which represents the counts of characters in the current window.

2. Check if the current window size (i - s1.length) is greater than or equal to the length of s1. If it is, then we need to remove the first character from the current window, so we decrement the count of that character in s2Counts.

3. Check if s1Counts (which represents the counts of characters in s1) is equal to s2Counts (which represents the counts of characters in the current window). If they are equal, then we have found a permutation of s1 in s2, so we return true.

If we reach the end of the loop without finding a permutation of s1 in s2, we return false.
 */