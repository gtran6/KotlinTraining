package Backtracking

fun permute(nums: IntArray): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    backtrack3(nums, res, mutableListOf(), mutableSetOf(), 0)
    return res
}

fun backtrack3(nums: IntArray, res: MutableList<List<Int>>, list: MutableList<Int>, set: MutableSet<Int>, index: Int) {
    if (list.size == nums.size) {
        res.add(list.toList())
        return
    }

    for (i in index until nums.size) {
        if (!set.contains(nums[i])) {
            list.add(nums[i])
            set.add(nums[i])
            backtrack3(nums, res, list, set, index)
            list.removeAt(list.size-1)
            set.remove(nums[i])
        }
    }
}
fun main() {
    val nums = intArrayOf(1,2,3)
    println(permute(nums))
}
