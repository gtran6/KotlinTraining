package Basics

fun main() {
    var num:List<Int> = listOf(8, 5, 6, 9)
    println(bubbleSort(num))
}

fun bubbleSort(num : List<Int>) : List<Int> {
    val result = num.toMutableList()
    var swap = true

    while (swap) {
        swap = false
        for (i in 0 until result.size-1) {
            if (result[i] > result[i+1]) {
                val tmp = result[i]
                result[i] = result[i+1]
                result[i+1] = tmp
                swap = true
            }
        }
    }

    return result
}