package TwoPointers

fun reverseWords(sentence: String) : String {
    return sentence.trim().split(" ").reversed().joinToString(" ")
}
fun main() {
    val sentence = "To be or not to be"
    println(reverseWords(sentence))
}