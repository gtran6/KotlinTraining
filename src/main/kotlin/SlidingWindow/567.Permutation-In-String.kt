package SlidingWindow

fun checkInclusion(s1: String, s2: String): Boolean {
    val s1Counts = IntArray(26)
    val s2Counts = IntArray(26)

    for (c in s1) {
        s1Counts[c - 'a']++
    }

    s2.indices.forEach { i ->
        s2Counts[s2[i] - 'a']++

        if (i >= s1.length) {
            s2Counts[s2[i - s1.length] - 'a']--
        }

        if (s1Counts.contentEquals(s2Counts)) {
            return true
        }
    }
    return false
}

fun main() {
    val s1 = "ab"
    val s2 = "eidboaoo"
    println(checkInclusion(s1, s2))
}