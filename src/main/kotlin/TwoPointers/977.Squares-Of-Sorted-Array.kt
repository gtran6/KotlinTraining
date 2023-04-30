package TwoPointers

import kotlin.math.abs

fun sortedSquares1(nums: IntArray): IntArray {
    val res = IntArray(nums.size) // BE NOTICE
    var start = 0
    var end = nums.size - 1
    (nums.size - 1 downTo 0).forEach { i ->
        if (abs(nums[start]) > abs(nums[end])) {
            res[i] = nums[start] * nums[start]
            start++
        } else {
            res[i] = nums[end] * nums[end]
            end--
        }
    }
    return res
}