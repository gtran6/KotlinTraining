package string

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    var map = mutableMapOf<Char, Int>()

    for (c in magazine) {
        map[c] = map.getOrDefault(c, 0) + 1
    }
    for (c in ransomNote) {
        if (map[c] == 0 || !map.contains(c)) return false
        map[c] = map[c]!! - 1
    }
    return true
}
fun main() {
    val ransomNote = "aa"
    val magazine = "aab"
    println(canConstruct(ransomNote, magazine))
}