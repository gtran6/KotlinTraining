package DynamicProgramming

fun longestPalindrome(s: String): String {
    var start = 0
    var max = 0

    for (i in s.indices) {
        //odd length palindrome
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
fun main() {
    val s = "babad"
    println(longestPalindrome(s))
}