package leetcode

fun canJump(nums: IntArray) : Boolean {
    var max = 0
    for (i in 0 until nums.size) {
        if (max < i) return false
        max = maxOf(max, nums[i] + i)
        if (max >= nums.size - 1) return true
    }
    return false
}
fun main() {
    val array = intArrayOf(3,2,1,0,4)
    println(canJump(array))
}