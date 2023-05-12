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

    //If the middle element is greater than the first element, then the first half of the array is sorted,
    // otherwise the second half of the array is sorted.
    while (left < right) {
        val mid = left + (right - left) / 2
        if (nums[mid] > nums[right]) {
            left = mid + 1
        } else {
            right = mid
        }
    }

    val pivot = left
    left = 0
    right = nums.size - 1

    if (target >= nums[pivot] && target <= nums[right]) {
        left = pivot
    } else {
        right = pivot - 1
    }

    while (left <= right) {
        val mid = left + (right - left) / 2

        if (nums[mid] == target) return true
        else if (nums[mid] < target) left = mid + 1
        else right = mid - 1
    }
    return false
}
fun main() {
    val nums = intArrayOf(2,5,6,0,0,1,2)
    val target = 3
    println(search1(nums, target))
}