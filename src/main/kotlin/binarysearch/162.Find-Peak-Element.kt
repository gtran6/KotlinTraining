package binarysearch

fun findPeakElement(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1

    while (left < right) {
        val mid = left + (right - left) / 2
        if (nums[mid] < nums[mid+1]) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left
}
fun main() {
    val nums = intArrayOf(1,2,1,3,5,6,4)
    println(findPeakElement(nums))
}