package leetcode

fun peakSignalStrength(nums: List<Int>) : Int {
    var left = 0
    var right = nums.size - 1

    while (left < right) {
        var mid = (left + right)/2
        if (nums[mid] > nums[mid+1]) //If that is the case, this would mean that the peak element will always be on the left of the middle element.
            right = mid

        else // the peak must be on the right of the middle element.
            left = mid + 1
    }
    return left
}
fun main() {
    var nums = listOf(1,2,4,3,5,7)
    nums = listOf(1, 2, 4, 3, 6, 5, 10, 19, 8, 170);
    println(peakSignalStrength(nums))
}