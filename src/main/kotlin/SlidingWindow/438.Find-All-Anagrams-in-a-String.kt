package SlidingWindow

fun findAnagrams(s: String, p: String): List<Int> {
    val res = mutableListOf<Int>()
    val sCount = IntArray(26)
    val pCount = IntArray(26)

    for (c in p) {
        pCount[c - 'a']++
    }

    for (i in s.indices) {
        sCount[s[i] - 'a']++

        if (i >= p.length) {
            sCount[s[i - p.length] - 'a']--
        }
        if (sCount.contentEquals(pCount)) {
            res.add(i - p.length + 1)
        }
    }
    return res
}
fun main() {
    val s = "abab"
    val p = "ab"
    println(findAnagrams(s, p))
}