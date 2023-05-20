package Backtracking

fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    nums.sort() // sort to eliminate duplicate later
    val res = mutableListOf<List<Int>>()
    backtrack6(nums, 0, mutableListOf(), res)
    return res
}

fun backtrack6(nums: IntArray, index: Int, list: MutableList<Int>, res: MutableList<List<Int>>) {
    res.add(list.toList())

    for (i in index until nums.size) {
        if (i > index && nums[i] == nums[i-1]) continue // skip duplicates

        list.add(nums[i])
        backtrack6(nums, i+1, list, res)
        list.removeAt(list.size - 1)
    }
}
fun main() {
    val nums = intArrayOf(1,2,2)
    println(subsetsWithDup(nums))
}
