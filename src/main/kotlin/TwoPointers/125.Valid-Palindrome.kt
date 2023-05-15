package TwoPointers

fun isPalindrome1(s: String): Boolean {
    var newString = s.lowercase().filter { it.isLetterOrDigit() } // -> amanaplanacanalpanama
    var start = 0
    var end = newString.length - 1

    while (start <  end) {
        if (newString[start] != newString[end]) return false
        else start++
            end--
    }
    return true
}
fun main() {
    val s = "A man, a plan, a canal: Panama"
    println(isPalindrome1(s))
}