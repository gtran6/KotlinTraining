package string

fun checkForA(s: String) : Boolean {
    if (s.isEmpty()) return false
    return s.last().lowercaseChar() == 'a' || checkForA(s.substring(1))
}
fun main() {
    val s = "DBCCa"
    println(checkForA(s))
}