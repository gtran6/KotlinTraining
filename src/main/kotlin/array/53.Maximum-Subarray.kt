package array

fun maxSubArray(nums: IntArray): Int {
    var sum = nums[0]
    var curr = nums[0]
    for (i in 1 until nums.size) {
        if (curr < 0) curr = nums[i]
        else curr += nums[i]

        if (sum < curr) sum = curr
    }
    return sum
}
fun main() {
    val nums = intArrayOf(-2,1,-3,4,-1,2,1,-5,4)
    println(maxSubArray(nums))
}