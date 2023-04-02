package TwoPointers

fun validPalindrome(s: String) : Boolean {
    var start = 0
    var end = s.length - 1
    while (start < end) {
        if (s[start] != s[end]) {
            return isPalindrome(s, start+1, end) || isPalindrome(s, start, end-1)
        } else {
            start++
            end--
        }
    }
    return true
}
fun isPalindrome(s: String, start_: Int, end_: Int) : Boolean {
    var start = start_
    var end = end_
    while (start < end) {
        if (s[start] != s[end]) return false
        else
            start++
            end--
    }
    return true
}
fun main() {
    val s = "abc"
    println(validPalindrome(s))
}