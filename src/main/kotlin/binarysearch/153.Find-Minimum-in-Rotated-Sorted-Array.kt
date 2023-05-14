package binarysearch

fun findMin(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1

    while (left < right) {
        val mid = left + (right - left) / 2
        if (nums[mid] > nums[right]) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return nums[left]
}
fun main() {
    val nums = intArrayOf(3,4,5,1,2)
    println(findMin(nums))
}