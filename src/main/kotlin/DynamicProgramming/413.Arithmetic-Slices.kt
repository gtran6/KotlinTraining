package DynamicProgramming

fun numberOfArithmeticSlices(nums: IntArray): Int {
    val n = nums.size
    if (n < 3) return 0

    var count = 0
    var dp = 0

    for (i in 2 until n) {
        if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
            dp += 1
            count += dp
        } else {
            dp = 0
        }
    }
    return count
}
fun main() {
    val nums = intArrayOf(1,2,3,4)
    println(numberOfArithmeticSlices(nums))
}