package Palindrome

fun countSubstrings(s: String): Int {
/*    // dp
    var res = 0
    val dp = Array(s.length) {BooleanArray(s.length)}

    for(i in s.lastIndex downTo 0) {
        for(j in i..s.lastIndex) {
            dp[i][j] = s[i] == s[j] && (j-i+1 < 3 || dp[i+1][j-1])
            if(dp[i][j]) res++
        }
    }
    return res*/

    //two-pointer
    var result = 0
    for (i in s.indices) {
        var l = i
        var r = i
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            result++
            l--
            r++
        }

        l = i
        r = i+1
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            result++
            l--
            r++
        }
    }
    return result
}
fun main() {
    val s = "aaa"
    println(countSubstrings(s))
}