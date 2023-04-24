package array

fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
    var rows = mat.size
    var cols = mat[0].size
    if (rows*cols != r*c) return mat
    val res = Array(r) {IntArray(c)}
    for (i in 0 until r) {
        for (j in 0 until c) {
            val k = i * c + j
            res[i][j] = mat[k / cols][k % cols]
        }
    }
    return res
}
fun main() {
    val mat = arrayOf(intArrayOf(1,2), intArrayOf(3,4))
    val r = 1
    val c = 4
    println(matrixReshape(mat, r, c))
}