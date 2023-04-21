package array

fun pivotIndex(nums: IntArray): Int {
    var leftSum = 0
    var rightSum = nums.sum()

    for (i in nums.indices) {
        rightSum -= nums[i]
        if (leftSum == rightSum) return i
        leftSum += nums[i]
    }
    return -1
}
fun main() {
    val nums = intArrayOf(1,7,3,6,5,6)
    println(pivotIndex(nums))
}