package DynamicProgramming

fun rob1(nums: IntArray): Int {
    val n = nums.size

    // If there are no houses, return 0
    if (n == 0) return 0

    // If there is only one house, return its value
    if (n == 1) return nums[0]

    // Calculate the maximum amount of money if we rob the first house
    val robCurrent = robRange(nums, 0, n - 2)

    // Calculate the maximum amount of money if we don't rob the first house
    val robPrevious = robRange(nums, 1, n - 1)

    // Return the maximum amount between robCurrent and robPrevious
    return maxOf(robCurrent, robPrevious)
}

// Helper function to calculate the maximum amount of money that can be robbed in a range of houses
fun robRange(nums: IntArray, start: Int, end: Int): Int {
    var prevMax = 0
    var currMax = 0

    for (i in start..end) {
        val temp = currMax
        currMax = maxOf(prevMax + nums[i], currMax)
        prevMax = temp
    }

    return currMax
}
fun main() {
    val nums = intArrayOf(2,3,2)
    println(rob1(nums))
}