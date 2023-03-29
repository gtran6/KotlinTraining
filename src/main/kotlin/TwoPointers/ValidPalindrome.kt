package TwoPointers

fun isPalindrome(s: String) : Boolean {
    var newString = s.toLowerCase().filter { it.isLetterOrDigit() }
    var left = 0
    var right = newString.length - 1
    while (left < right) {
        if (newString[left] != newString[right])
            return false
        else
            left++
            right--
    }
    return true
}
fun main() {
    val s = "A man, a plan, a canal: Panama"
    println(isPalindrome(s))
}