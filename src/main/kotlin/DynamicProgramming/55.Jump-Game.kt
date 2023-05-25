package DynamicProgramming

fun canJump(nums: IntArray): Boolean {
    if (nums.size == 1) return true
    var max = 0

    for (i in 0 until nums.size) {
        if (max < i) return false

        max = maxOf(max, nums[i] + i)
        if (max >= nums.size - 1) return true
    }
    return false
}
fun main() {
    val nums = intArrayOf(2,3,1,1,4)
    println(canJump(nums))
}