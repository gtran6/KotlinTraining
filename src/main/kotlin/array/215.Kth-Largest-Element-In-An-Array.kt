package array

fun findKthLargest(nums: IntArray, k: Int): Int {
    nums.sort()
    if (nums.size <= 1) return nums[0]
    for (i in 0 until nums.size-1) {
        return nums[nums.size - k]
    }
    return 0
}
fun main() {
    val nums = intArrayOf(3,2,3,1,2,4,5,5,6)
    val k = 4
    println(findKthLargest(nums, k))
}