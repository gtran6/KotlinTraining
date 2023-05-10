package Backtracking

fun combine(n: Int, k: Int): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    backtrack2(n, 1, k, mutableListOf(), res)
    return res
}

fun backtrack2(n: Int, index: Int, k: Int, list: MutableList<Int>, res: MutableList<List<Int>>) {
    if (list.size == k) {
        res.add(list.toList())
        return
    }

    for (i in index..n) {
        list.add(i)
        backtrack2(n, i+1, k, list, res)
        list.removeAt(list.size - 1)
    }
}
fun main() {
    val n = 4
    val k = 2
    println(combine(n, k))
}
