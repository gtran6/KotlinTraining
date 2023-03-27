package leetcode.OperatingSystem

fun reverseWords1(s: String) : String {
    return s.trim().split(" ").reversed().filter { it.isNotBlank() }.joinToString(" ")
}
fun main() {
    val s = "  the sky   is blue"
    println(reverseWords1(s))
}