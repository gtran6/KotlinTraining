package array

fun searchInsert(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.size - 1

    while (start <= end) {
        var mid = start + (end - start) / 2
        if (nums[mid] == target) return mid
        else if (nums[mid] < target) start = mid + 1
        else end = mid - 1
    }
    return start
}
fun main() {
    val nums = intArrayOf(1,3,5,6)
    val target = 7
    println(searchInsert(nums, target))
}