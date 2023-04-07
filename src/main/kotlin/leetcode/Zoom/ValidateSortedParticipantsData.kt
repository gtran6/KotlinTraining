package leetcode.Zoom

fun inOrderBST(array: Array<String>, n: Int): Boolean {
    if (n == 0 || n == 1) return true

    for (i in 1 until n) {
        // the result is 1 means that the current element is greater than the previous element
        // the function returns false, indicating that the array is not sorted
        if (array[i-1].compareTo(array[i]) == 1) return false
    }
    return true
}
fun main() {
    val array = arrayOf("Caryl", "Elia", "Elvira", "Jeanette", "Lala", "Latasha", "Lyn")
    val n = array.size
    println(inOrderBST(array, n))
}