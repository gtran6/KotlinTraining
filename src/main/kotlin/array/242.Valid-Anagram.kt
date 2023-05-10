package array

//  What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
// using HashMap
fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val sCount = HashMap<Char, Int>()
    val tCount = HashMap<Char, Int>()
    for (c in s) {
        sCount[c] = sCount.getOrDefault(c, 0) + 1
    }
    for (c in t) {
        tCount[c] = tCount.getOrDefault(c, 0) + 1
    }
    return sCount == tCount
}

fun isAnagram1(s: String, t: String): Boolean {
    val sCount = IntArray(26)
    val tCount = IntArray(26)
    for (c in s) {
        sCount[c - 'a']++
    }
    for (c in t) {
        tCount[c - 'a']++
    }
    return sCount.contentEquals(tCount)
}
fun main() {
    val s = "rat"
    val t = "car"
    println(isAnagram(s, t))
}