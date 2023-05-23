package Backtracking

fun permuteUnique(nums: IntArray): List<List<Int>> {
    nums.sort()
    val res = mutableListOf<List<Int>>()
    val used = BooleanArray(nums.size)
    backtrack(nums, res, mutableListOf(), used)
    return res
}

fun backtrack(nums: IntArray, res: MutableList<List<Int>>, list: MutableList<Int>, used: BooleanArray) {
    if (list.size == nums.size) {
        res.add(list.toList())
        return
    }

    for (i in nums.indices) {
        if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue

        used[i] = true
        list.add(nums[i])
        backtrack(nums, res, list, used)
        list.removeAt(list.size - 1)
        used[i] = false
    }
}
fun main() {
    val nums = intArrayOf(1,1,2)
    println(permuteUnique(nums))
}
