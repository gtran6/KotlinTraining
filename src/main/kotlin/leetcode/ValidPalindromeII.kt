package leetcode

fun validPalindrome(s: String) : Boolean {
    var left = 0
    var right = s.length-1

    while (left < right) {
        if (s.get(left) != s.get(right)) {
            if (isPalindrome1(s, left, right - 1)) return true
            else if (isPalindrome1(s, left+1, right)) return true
            else return false
        } else {
            left++
            right--
        }
    }
    return true
}

fun isPalindrome1(s: String, left_: Int, right_: Int): Boolean {
    var left = left_
    var right = right_

    while (left < right) {
        if (s.get(left) != s.get(right)) {
            return false
        } else {
            left++
            right--
        }
    }
    return true
}

fun main() {
    val s = "aba"
    println(validPalindrome(s))
}