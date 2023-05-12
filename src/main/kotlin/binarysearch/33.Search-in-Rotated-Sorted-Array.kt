package binarysearch

fun search(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) return -1
    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        val mid = left + (right - left) / 2

        if (nums[mid] == target) {
            return mid
        }
        if (nums[left] <= nums[mid]) {
            if (target >= nums[left] && target < nums[mid]) {
                right = mid-1
            } else {
                left = mid+1
            }
        } else {
            if (target > nums[mid] && target <= nums[right]) {
                left = mid+1
            } else {
                right = mid-1
            }
        }
    }
    return -1
}
fun main() {
    val nums = intArrayOf(4,5,6,7,0,1,2)
    val target = 0
    println(search(nums, target))
}
/*

The basic idea is to divide the array into two halves, and check if the target is in the left or right half.
If the left half is sorted (i.e., nums[left] <= nums[mid]), we can check if the target is within that range.
If it is, we update the right boundary to mid - 1. Otherwise, we update the left boundary to mid + 1.
If the right half is sorted (i.e., nums[mid] < nums[right]), we can check if the target is within that range.
If it is, we update the left boundary to mid + 1. Otherwise, we update the right boundary to mid - 1.

 */