package SlidingWindow

// sliding window works when the elements in nums are positive integers.
fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
    var product = 1
    var left = 0
    var count = 0

    for (right in nums.indices) {
        product *= nums[right]

        /*
        If the product becomes greater than or equal to k, it enters a while loop.
        In the while loop, it divides the product by nums[left] and increments left.
        This step shrinks the window from the left until the product becomes less than
        k or the left and right pointers meet.
         */
        while (product >= k && left <= right) {
            product /= nums[left]
            left++
        }
        /*
        After the while loop, it adds the number of subarrays that can be formed within
        the current window (from left to right) to the count.
         */
        count += right - left + 1
    }
    return count
}
fun main() {
    val nums = intArrayOf(10,5,2,6)
    val k = 100
    println(numSubarrayProductLessThanK(nums, k))
}