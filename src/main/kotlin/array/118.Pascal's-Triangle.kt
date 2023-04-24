package array

fun generate(numRows: Int): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    for (i in 0 until numRows) {
        val row = mutableListOf<Int>()
        for (j in 0..i) {
            if (j == 0 || j == i) {
                row.add(1)
            } else {
                val prevRow = res[i-1]
                row.add(prevRow[j-1] + prevRow[j])
            }
        }
        res.add(row)
    }
    return res
}
fun main() {
    val numRows = 5
    println(generate(5))
}