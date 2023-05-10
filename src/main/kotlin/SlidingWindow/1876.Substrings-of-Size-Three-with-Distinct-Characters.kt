package SlidingWindow

fun countGoodSubstrings(s: String): Int {
    var count = 0

    for (i in 0 until s.length-2) {
        val substring = s.substring(i, i + 3)

        if (substring.toSet().size == 3) {
            count++
        }
    }
    return count
}
fun main() {
    val s = "aababcabc"
    println(countGoodSubstrings(s))
}