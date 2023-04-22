package hashmap

fun isIsomorphic(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    val map = HashMap<Char, Char>()
    val used = HashSet<Char>()

    for (c in s.indices) {
        val charS = s[c]
        val charT = t[c]

        if (map.contains(charS)) {
            if (map[charS] != charT) return false
        } else {
            if (used.contains(charT)) return false
            map[charS] = charT
            used.add(charT)
        }
    }
    return true
}
fun main() {
    val s = "paper"
    val t = "title"
    println(isIsomorphic(s, t))
}