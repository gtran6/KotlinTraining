package Backtracking

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    fun backtrack(combination: MutableList<Int>, start: Int, target: Int){
        if (target < 0) {
            return
        }
        if (target == 0) {
            result.add(combination.toList())
            return
        }
        for (i in start until candidates.size) {
            combination.add(candidates[i])
            backtrack(combination, i, target - candidates[i])
            combination.removeAt(combination.size - 1)
        }
    }
    candidates.sort()
    backtrack(mutableListOf(), 0, target)
    return result.distinct()
}
fun main() {
    val candidates = intArrayOf(2,3,6,7)
    val target = 7
    println(combinationSum(candidates, target))
}