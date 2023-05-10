package Backtracking

/*
Given a set of non-negative integers and a value sum, the task is to check if there is a subset of the given set whose sum is equal to the given sum.

Input: set[] = {5,10,12,13,15,18}, sum = 30
Output: [[5, 10, 15], [5, 12, 13], [12, 18]]

 */

fun SubsetSum(numbers: IntArray, target: Int) : List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    backtrack(numbers, 0, mutableListOf(), res, target)
    return res
}

fun backtrack(numbers: IntArray,index: Int, currentSubset: MutableList<Int>, res: MutableList<List<Int>>, target: Int) {
    val sum = currentSubset.sum()

    // check if the current subset's sum is equal to the target,
    // if it is, add the current subset to the result list
    if (sum == target) {
        res.add(currentSubset.toList())
        return
    }

    if (sum > target || index >= numbers.size) return

    // include the current number
    currentSubset.add(numbers[index])
    // make a recursive call to explore further with the updated subset
    backtrack(numbers, index + 1, currentSubset, res, target)
    // remove the current number from the subset to backtrack
    currentSubset.removeAt(currentSubset.size - 1)

    // exclude the current number and make recursive call to explore further without the current number
    backtrack(numbers, index + 1, currentSubset, res, target)
}
fun main() {
    val numbers = intArrayOf(5,10,12,13,15,18)
    val target = 30

    println(SubsetSum(numbers, target))
}
