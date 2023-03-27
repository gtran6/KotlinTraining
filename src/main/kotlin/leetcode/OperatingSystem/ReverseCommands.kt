package leetcode.OperatingSystem

fun reverseWords(s:String): String {

    // 1. trim the leading and trailing spaces
    // 2. split the words into spaces, there might be more than one space between each word
    // 3. reverse the array of strings
    // 4. convert the reversed array into a string
    return s.trim().split(" ").reversed().joinToString(" ")
}
fun main() {
    val s = " *.html pages.tar.gz czvf tar "
    println(reverseWords(s))
}