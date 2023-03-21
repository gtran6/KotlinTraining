package leetcode.Facebook

fun findMin(nums: IntArray): Int {
    var start = 0
    var end = nums.size-1

    while (start < end) {
        val mid = (start + end) / 2
        if (nums[mid] > nums[end]) {
            start = mid + 1
        } else {
            end = mid
        }
    }
    return nums[start]
}
fun main() {
    var nums = intArrayOf(3,4,5,1,2)
    println(findMin(nums))
}