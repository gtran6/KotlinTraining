package leetcode.Facebook

/*
1. Initialize two pointers, i and j, to start traversing from S and W, respectively.

2. Check if letters currently pointed to by i and j of both words are equal. Otherwise, return False.

3. For each equal letter found:

Get the length of the repeating sequences of the equal letter found in both words.

The length of the repeating sequence of W letters should be less than or equal to the length of the repeating sequence of S letters.

The length of the repeating sequence of S letters should be greater than or equal to 3.

4. If any of the conditions mentioned in step 3 fails, return false.

5. If the ends of both strings are reached, return true.
 */

fun flagWords(S: String?, W: String?): Boolean {
    if (S == null || W == null) return false

    var i = 0
    var j = 0
    while (i < S.length && j < W.length) {
        if (S[i] == W[j]) {
            val len1: Int = repeatedLetters(S, i)
            val len2: Int = repeatedLetters(W, j)
            if (len1 < 3 && len1 != len2 || len1 in 3 until len2) return false

            // If the repeated letters meet our criteria, we move the indices i and j forward
            // by the length of the repeated letters we just checked.
            i += len1
            j += len2
        } else {
            return false
        }
    }
    return i == S.length && j == W.length
}

fun repeatedLetters(s: String, i: Int): Int {
    // Initializes a variable 'tmp' to the value of the argument i.
    // This variable will be used to keep track of where we are in s.
    var tmp = i
    // This sets up a loop that will run as long as the character at index
    // tmp in s is the same as the character at index i.
    while (tmp < s.length && s[tmp] == s[i]) {
        tmp++ // move tmp to the next character
    }
    return tmp-i // return the length of the repeated characters we just found in 's' string
}
fun main() {
    val s = "mooooronnn"
    val w = "moron"
    println(flagWords(s, w))
}