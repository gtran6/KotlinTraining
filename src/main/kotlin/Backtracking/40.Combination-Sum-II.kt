package Backtracking

fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    candidates.sort()
    val res = mutableListOf<List<Int>>()
    backtrack7(candidates, target, res, 0, mutableListOf())
    return res
}

fun backtrack7(candidates: IntArray, target: Int, res: MutableList<List<Int>>, index: Int, list: MutableList<Int>) {
    if (target == 0) {
        res.add(list.toList())
        return
    }

    for (i in index until candidates.size) {
        if (i > index && candidates[i] == candidates[i-1]) continue

        if (candidates[i] > target) break
        list.add(candidates[i])
        backtrack7(candidates, target - candidates[i], res, i+1, list)
        list.removeAt(list.size-1)
    }
}
fun main() {
    val candidates = intArrayOf(10,1,2,7,6,1,5)
    val target = 8
    println(combinationSum2(candidates, target))
}
