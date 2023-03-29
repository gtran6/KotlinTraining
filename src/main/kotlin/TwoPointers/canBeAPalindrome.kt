package TwoPointers

fun canPalindrome(s: String) : Boolean {
    var start = 0
    var end = s.length - 1
    while (start < end) {
        if (s[start] != s[end]) {
            return if (isPalindrome2(s, start, end-1)) true
            else isPalindrome2(s, start+1, end)
        } else {
            start++
            end--
        }
    }
    return true
}

fun isPalindrome2(s: String, start_: Int, end_: Int): Boolean {
    var start = start_
    var end = end_
    while (start < end) {
        if (s[start] != s[end])
            return false
        else
            start++
            end--
    }
    return true
}
fun main() {
    val s = "madame"
    println(canPalindrome(s))
}
