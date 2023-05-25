package DynamicProgramming

fun jump(nums: IntArray): Int {
    if (nums.size < 2) return 0
    var currMax = nums[0]
    var max = nums[0]
    var hops = 1

    for (i in nums.indices) {

        if (currMax < i) {
            hops++
            currMax = max
        }
        max = maxOf(max, nums[i] + i)
    }
    return hops
}
fun main() {
    val nums = intArrayOf(2,3,1,1,4)
    println(jump(nums))
}