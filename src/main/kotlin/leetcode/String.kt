package leetcode

fun main() {
    reverseStr("abcdefg", 2)
}
fun reverseStr(s: String, k: Int): String? {
     val result = (s.chunked(k).mapIndexed {
            index, str -> if (index % 2 == 0) str.reversed() else str
    }.joinToString(""))
    println(result)
    return null
}