package TwoPointers

import kotlin.math.abs

fun sortedSquares(nums: IntArray): IntArray {
    //return nums.map { it*it }.sorted().toIntArray()
    val result = IntArray(nums.size)
    var start = 0
    var end = nums.size - 1
    for (i in nums.size-1 downTo 0) {
        if (abs(nums[start]) > abs(nums[end])) {
            result[i] = nums[start] * nums[start]
            start++
        } else {
            result[i] = nums[end] * nums[end]
            end--
        }
    }
    return result
}
fun main() {
    val nums = intArrayOf(-4,-1,0,3,10)
    println(sortedSquares(nums))
}