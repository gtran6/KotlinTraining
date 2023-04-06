package SlidingWindow

fun maximumUniqueSubarray(nums: IntArray): Int {
    var start = 0
    var end = 0
    var maxScore = 0
    var sum = 0
    val set = HashSet<Int>()

    while (end < nums.size) {
        if (!set.contains(nums[end])) {
            set.add(nums[end])
            sum += nums[end]
            maxScore = maxOf(maxScore, sum)
            end++
        } else {
            set.remove(nums[start])
            sum -= nums[start]
            start++
        }
    }
    return maxScore
}
fun main() {
    val nums = intArrayOf(4,2,4,5,6)
    println(maximumUniqueSubarray(nums))
}