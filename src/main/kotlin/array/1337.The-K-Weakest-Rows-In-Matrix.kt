package array

fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
    // Create an array of size m to store the strength of each row
    val strengths = IntArray(mat.size)
    // Compute the strength of each row
    for (i in mat.indices) {
        strengths[i] = mat[i].sum()
    }
    // Create a list of row indices sorted by their strengths
    val sortedIndices = (mat.indices).sortedBy { strengths[it] }

    // Return the first k indices in the sorted list
    return sortedIndices.take(k).toIntArray()
}
fun main() {
    val mat = arrayOf(intArrayOf(1,1,0,0,0), intArrayOf(1,1,1,1,0), intArrayOf(1,0,0,0,0), intArrayOf(1,1,0,0,0), intArrayOf(1,1,1,1,1))
    val k = 3
    println(kWeakestRows(mat, k).contentToString())
}