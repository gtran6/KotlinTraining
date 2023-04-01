package TwoPointers

fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort()
    val result = HashSet<List<Int>>()

    for (i in nums.indices) {
        var start = i + 1
        var end = nums.size - 1

        while (start < end) {
            val triple = nums[i] + nums[start] + nums[end]

            when {
                triple < 0 -> start++
                triple > 0 -> end--
                else -> result.add(listOf(nums[i], nums[start], nums[end]))
            }
        }
    }
    return result.toList()
}
fun main() {
    val nums = intArrayOf(-1,0,1,2,-1,-4)
    println(threeSum(nums))
}