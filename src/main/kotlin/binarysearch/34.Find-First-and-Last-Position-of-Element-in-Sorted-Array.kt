package binarysearch

fun searchRange(nums: IntArray, target: Int): IntArray {
    if (nums.isEmpty()) return intArrayOf(-1,-1)
    return intArrayOf(searchLeft(nums, target), searchRight(nums, target))
}

fun searchRight(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    var index = -1
    if (target < nums[0]) return -1
    if (target > nums[right]) return -1
    var ret = -1
    while (left <= right) {
        index = left + (right - left) / 2
        if (nums[index] == target){
            ret = index
            left = index + 1 // update the left pointer to index+1 to search the right half of the array
        } else if (nums[index] < target) {
            left = index + 1
        } else {
            right = index - 1
        }
    }
    return ret
}

fun searchLeft(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    var index = -1
    if (target < nums[0]) return -1
    if (target > nums[right]) return -1
    var ret = -1
    while (left <= right) {
        index = left + (right - left) / 2
        if (nums[index] == target) {
            ret = index
            right = index - 1 // update the right pointer to index - 1 to search for the left half of the array
        } else if(nums[index] < target) {
            left = index + 1
        } else {
            right = index - 1
        }
    }
    return ret
}
fun main() {
    val nums = intArrayOf(5,7,7,8,8,10)
    val target = 8
    println(searchRange(nums, target).contentToString())
}