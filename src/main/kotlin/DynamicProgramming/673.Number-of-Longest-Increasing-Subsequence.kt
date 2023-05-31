package DynamicProgramming

fun findNumberOfLIS(nums: IntArray): Int {
    val n = nums.size
    val lengths = IntArray(n) { 1 }
    val counts = IntArray(n) { 1 }
    var maxLength = 1

    for (i in 1 until n) {
        for (j in 0 until i) {
            if (nums[i] > nums[j]) {
                if (lengths[j] + 1 > lengths[i]) {
                    lengths[i] = lengths[j] + 1
                    counts[i] = counts[j]
                } else if (lengths[j] + 1 == lengths[i]) {
                    counts[i] += counts[j]
                }
            }
        }
        maxLength = maxOf(maxLength, lengths[i])
    }

    var result = 0
    for (i in 0 until n) {
        if (lengths[i] == maxLength) {
            result += counts[i]
        }
    }

    return result
}
fun main() {
    val nums = intArrayOf(1,3,5,4,7)
    println(findNumberOfLIS(nums))
}