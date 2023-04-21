package array

fun runningSum(nums: IntArray): IntArray {
    var sum = IntArray(nums.size)
    sum[0] = nums[0]
    for (i in 1..nums.size - 1) {
        sum[i] = sum[i-1] + nums[i]
    }
    return sum
}
fun main() {
    val nums = intArrayOf(1,2,3,4)
    println(runningSum(nums))
}