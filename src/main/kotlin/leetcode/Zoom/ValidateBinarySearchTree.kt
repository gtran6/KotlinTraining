package leetcode.Zoom

fun inOrderBST(array: IntArray, n: Int): Boolean {
    if (n == 0 || n == 1) return true

    for (i in 1 until n) {
        if (array[i-1].compareTo(array[i]) == 1) return false
    }
    return true

    //return array.contentEquals(array.sortedArray())
}
fun main() {
    val array = intArrayOf(8,12,15,21,24,32,45)
    val n = array.size
    println(inOrderBST(array, n))
}