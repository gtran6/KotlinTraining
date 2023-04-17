package TwoPointers

fun removeChar(str: String): String {
    return str.substring(1, str.length-1)
}
fun main() {
    val str = "eloquent"
    println(removeChar(str))
}