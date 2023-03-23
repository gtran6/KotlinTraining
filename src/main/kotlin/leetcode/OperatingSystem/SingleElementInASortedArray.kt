package leetcode.OperatingSystem

fun SingleNonDuplicate(nums: List<Int>) : Int {
/*    for (i in 0 until nums.size step 2) {
        if (nums[i] != nums[i+1] || i == nums.size-1) {
            return nums[i]
        }
    }
    return -1*/
    var low = 0
    var high = nums.size - 1

    while (low < high) {
        var mid = low + (high - low) / 2
        if (mid % 2 == 1) mid --
        if (nums[mid] == nums[mid+1])
            low = mid + 2
        else
            high = mid
    }
    return nums[low]
}
fun main() {
    val nums = listOf(1,1,2,3,3,4,4,8,8)
    println(SingleNonDuplicate(nums))
}