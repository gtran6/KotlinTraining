package array

fun intersection(nums: Array<IntArray>): List<Int> {
    val common = mutableListOf<Int>()
    var firstArray = nums[0]

    for (num in firstArray) {
        var present = true
        for (i in 1 until nums.size) {
            if (!nums[i].contains(num)) {
                present = false
                break
            }
        }
        if (present) common.add(num)
    }
    return common.sorted()
}
fun main() {
    val nums = arrayOf(intArrayOf(3,1,2,4,5), intArrayOf(1,2,3,4), intArrayOf(3,4,5,6))
    println(intersection(nums))
}