package array

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()

    for (i in nums.indices) {
        if (map.contains(target - nums[i])) {
            return intArrayOf(map[target-nums[i]]!!, i)
        }
        map[nums[i]] = i
    }
    throw Exception("")
}
fun main() {
    val nums = intArrayOf(2,7,11,15)
    val target = 9
    println(twoSum(nums, target).contentToString())
}