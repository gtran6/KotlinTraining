package TwoPointers

fun reverseWords1(s: String): String {
    val char = CharArray(s.length)
    var left = 0
    var right = 0

    while (right < s.length) {
        if (s[right] == ' ') {
            for (i in left until right) {
                char[i] = s[left + right - i - 1]
            }
            char[right] = ' '
            left = right + 1
        }
        right++
    }
    for (i in left until s.length) {
        char[i] = s[left + s.length - i - 1]
    }
    return String(char)
}
fun main() {
    val s = "Let's take LeetCode contest"
    println(reverseWords1(s))
}