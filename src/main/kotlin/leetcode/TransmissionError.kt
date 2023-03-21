package leetcode

fun transmissionError(arr: IntArray) : Int {
    var left = 0
    var right = arr.size - 1

    while (left < right) {
        if (arr[left] == arr[right]) {
            left++
            right--
        } else {
            if (isPalindrome(arr, left, right-1)) {
                return 1
            } else if (isPalindrome(arr, left+1, right)) {
                return 1
            } else {
                return -1
            }
        }
    }

    return 0
}

fun isPalindrome(arr: IntArray, left_: Int, right_: Int): Boolean {
    var left = left_
    var right = right_
    while (left < right) {
        if (arr[left] != arr[right]) {
            return false
        } else {
            left++
            right--
        }
    }
    return true
}

fun main() {
    var arr = intArrayOf(1,2,3,3,4,2,1)
    val res: Int = transmissionError(arr)
    println(res)
}