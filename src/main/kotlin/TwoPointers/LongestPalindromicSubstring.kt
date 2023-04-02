package TwoPointers

fun longestPalindrome(s: String): String {
    var start = 0
    var max = 0

    for (i in s.indices) {
        //odd length palindrome, l and r pointers start at the same position and expand outwards
        var l = i
        var r = i
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            if (r-l+1 > max) {
                start = l
                max = r-l+1
            }
            l--
            r++
        }

        //even length palindrome
        l = i
        r = i + 1
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            if (r-l+1 > max) {
                start = l
                max = r-l+1
            }
            l--
            r++
        }
    }
    return s.substring(start, start+max)
}
    /*
    // brute-force
    if (s.isEmpty()) return ""

    var longest = s.substring(0, 1)

    for (i in s.indices) {
        for (j in i+1 until s.length) {
            val substring = s.substring(i, j+1)
            if (isPalindrome3(substring) && substring.length > longest.length) {
                longest = substring
            }
        }
    }

    return longest
}

fun isPalindrome3(s: String) : Boolean {
    var start = 0
    var end = s.length-1
    while (start < end) {
        if (s[start++] != s[end--]) return false
    }
    return true
}
     */
fun main() {
    val s = "babad"
    println(longestPalindrome(s))
}