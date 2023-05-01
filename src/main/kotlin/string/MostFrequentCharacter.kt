package string

fun mostFrequentChar(s: String) : String {
    s.lowercase()
    if (s.isEmpty()) return ""
    val map = HashMap<Char, Int>()
    for (c in s) {
        map[c] = map.getOrDefault(c, 0) + 1
    }
    var mostFreqChar = s[0]
    var max = 0
    for (i in s.indices) {
        if (map[s[i]]!! > max || (map[s[i]]!! == max && s[i] < mostFreqChar)) {
            mostFreqChar = s[i]
            max = map[s[i]]!!
        }
    }
    return mostFreqChar.toString()
}
fun main() {
    val s = "xyyXzz"
    println(mostFrequentChar(s))
}