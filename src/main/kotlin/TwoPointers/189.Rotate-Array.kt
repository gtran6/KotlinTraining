package TwoPointers

fun rotate(nums: IntArray, k: Int): Unit {
    //use the modulo operator to ensure that k is always less than the length of the array
    val steps = k % (nums.size)
    reverse(nums, 0, nums.size - 1)
    reverse(nums, 0, steps - 1)
    reverse(nums, steps, nums.size - 1)
}
fun reverse(nums: IntArray, start: Int, end: Int) {
    var left = start
    var right = end
    while (left < right) {
        val tmp = nums[left]
        nums[left] = nums[right]
        nums[right] = tmp
        left++
        right--
    }
}
fun main() {
    val nums = intArrayOf(1,2,3,4,5,6,7)
    val k = 3
    println(rotate(nums, k))
}