package binarysearch

/*
The key difference from the regular binary search is that we cannot determine which half of the array is sorted,
due to the rotation. So, we need to check both halves of the array to determine which one is sorted and then
decide whether to search in that half or the other half.
 */
fun search1(nums: IntArray, target: Int): Boolean {
    if (nums.isEmpty()) return false
    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        // to avoid duplicates
        while (left < right && nums[left] == nums[left + 1]) ++left
        while (left < right && nums[right] == nums[right - 1]) --right

        val mid = left + (right - left) / 2

        if (nums[mid] == target) return true

        if (nums[mid] >= nums[left]) {
            if (target >= nums[left] && target < nums[mid]) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        } else {
            if (target <= nums[right] && target > nums[mid]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
    }
    return false
}
fun main() {
    val nums = intArrayOf(1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1)
    val target = 2
    println(search1(nums, target))
}