package leetcode.Facebook

fun minWindow(s: String, t: String): String {
    /*
    These lines convert the target string T into a character array tChars, and
    then create a mutable map tCounts to store the count of each character in T.
    The for loop iterates over tChars, and for each character c, it adds an entry
    to tCounts with the key c and the value equal to the count of c in T.
     */
    val tChars = t.toCharArray()
    val tCounts: MutableMap<Char, Int> = HashMap()
    for (c in tChars) {
        tCounts[c] = tCounts.getOrDefault(c, 0) + 1
    }

    /*
    These lines initialize some variables that will be used in the main loop of the function.
    left and right represent the left and right pointers of the current window, minWindow
    represents the current minimum window found, minWindowSize represents the size of the
    current minimum window found, and remaining represents the number of characters in T
    that have not yet been matched in the current window.
     */
    var left = 0
    var right = 0
    var minWindow = ""
    var minWindowSize = Int.MAX_VALUE
    var remaining = tCounts.size

    /*
    This is the main loop of the function. It iterates over the characters of the input string
    S from left to right. For each character c at the right pointer, it checks if c is in the
    target string T. If c is in T, it decrements the count of c in tCounts, and if the count
    becomes 0, it decrements the remaining count. The right pointer is then incremented.
     */
    while (right < s.length) {
        val c = s[right]
        if (tCounts.containsKey(c)) {
            tCounts[c] = tCounts[c]!! - 1
            if (tCounts[c] == 0) {
                remaining--
            }
        }
        right++

        /*
        The function then enters a nested loop that continues as long as remaining is 0
        which means that all characters in T have been matched in the current window. In this loop,
        the function checks if the current window is smaller than the current minimum window found.
        If it is, it updates the minWindow and minWindowSize variables to the current window.

        The function then moves the left pointer to the right by one position, and for the character
        cLeft at the left pointer, it checks if cLeft is in T. If cLeft is in T, it increments the
        count of cLeft in tCounts, and if the count becomes greater than 0, it increments the remaining count.

        The main loop then continues until the right pointer reaches the end of the input string S.
        At the end of the loop, the function returns the minimum window found.
         */
        while (remaining == 0) {
            if (right - left < minWindowSize) {
                minWindowSize = right - left
                minWindow = s.substring(left, right)
            }

            val cLeft = s[left]
            if (tCounts.containsKey(cLeft)) {
                tCounts[cLeft] = tCounts[cLeft]!! + 1
                if (tCounts[cLeft]!! > 0) {
                    remaining++
                }
            }
            left++
        }
    }
    return minWindow
}
fun main() {
    val s = "ADOBECODEBANC"
    val t = "ABC"
    println(minWindow(s, t))
}