package leetcode.Facebook

fun expressiveWords(s: String, words: Array<String>): Int {
    var count = 0
    for (word in words) {
        if (isStretchyWords(s, word)) {
            count++
        }
    }
    return count
}
fun isStretchyWords(s: String, word: String) : Boolean {
    if (s == null || word == null) return false
    var i = 0
    var j = 0
    while (i < s.length && j < word.length) {
        if (s[i] == word[j]) {
            val len1: Int = repeatedLetters2(s, i)
            val len2: Int = repeatedLetters2(word, j)
            if (len1 < 3 && len1 != len2 || len1 in 3 until len2) return false
            i += len1
            j += len2
        } else {
            return false
        }
    }
    return i == s.length && j == word.length
}
fun repeatedLetters2(s: String, i: Int) : Int {
    var tmp = i
    while (tmp < s.length && s[tmp] == s[i]) {
        tmp++
    }
    return tmp-i
}
fun main() {
    val s = "zzzzzyyyyy"
    val words = arrayOf("zzyy","zy","zyy")
    println(expressiveWords(s, words))
}