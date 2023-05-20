package Backtracking

fun subsets(nums: IntArray): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    backtrack1(nums, 0, mutableListOf(), res)
    return res
}

fun backtrack1(nums: IntArray, index: Int, list: MutableList<Int>, res: MutableList<List<Int>>) {
    res.add(list.toList())

    for (i in index until nums.size) {
        list.add(nums[i])
        backtrack1(nums, i+1, list, res)
        list.removeAt(list.size-1)
    }
}
fun main() {
    val nums = intArrayOf(1,2,3)
    println(subsets(nums))
}

/*
[1]
[1], [2], [1,2]
[1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]
 */
