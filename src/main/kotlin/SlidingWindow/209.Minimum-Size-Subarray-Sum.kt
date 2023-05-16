package SlidingWindow

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var min = Int.MAX_VALUE
    var left = 0
    var sum = 0

    for (right in nums.indices) {
        sum += nums[right]

        while (sum >= target && left <= right) {
            min = minOf(min, right - left + 1)
            sum -= nums[left]
            left++
        }
    }
    return if (min == Int.MAX_VALUE) 0 else min
}
fun main() {
    val nums = intArrayOf(2,3,1,2,4,3)
    val target = 7
    println(minSubArrayLen(target, nums))
}