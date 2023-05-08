package TwoPointers

fun moveZeroes(nums: IntArray): Unit {
    var left = 0
    var right = 0

    while (right <= nums.size - 1) {
        if (nums[left] == 0) {
            while (right < nums.size - 1 && nums[right] == 0) {
                right++
            }
            nums[left] = nums[right]
            nums[right] = 0
        }
        left++
        right++
    }
}
fun main() {
    val nums = intArrayOf(0,1,0,3,12)
    println(moveZeroes(nums))
}