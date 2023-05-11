package string

fun encode(strs: List<String>) : String {
    return strs.joinToString(":;")
}
fun decode(str: String) : List<String> {
    return str.split(":;")
}
fun main() {
    val strs = listOf("we", "say", ":", "yes")
    println(encode(strs))
    val str = encode(strs)
    println(decode(str))
}