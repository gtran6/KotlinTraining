package array

fun search(nums: IntArray, target: Int): Int {
    nums.sort()
    var start = 0
    var end = nums.size-1

    while (start <= end) {
        var mid = start + (end - start) / 2
        if (nums[mid] == target) {
            return mid
        } else if (nums[mid] < target) {
            start = mid + 1
        } else {
            end = mid - 1
        }
    }
    return -1
}
fun main() {
    val nums = intArrayOf(-1,0,3,5,9,12)
    val target = 9
    println(search(nums, target))
}