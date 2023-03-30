package SlidingWindow

fun minWindow(s: String, t: String): String {
    var indexS = 0
    var indexT = 0
    var result = ""
    var length = Int.MAX_VALUE

    while (indexS < s.length) {
        if (s[indexS] == t[indexT]) {
            indexT++
            if (indexT == t.length) {
                var start = indexS
                var end = indexS+1
                indexT--
                while (indexT >= 0) {
                    if (s[start] == t[indexT]) {
                        indexT--
                    }
                    start--
                }
                start++

                if (end - start < length) {
                    length = end - start
                    result = s.substring(start, end)
                }
                indexS = start
                indexT = 0
            }
        }
        indexS++
    }
    return result
}
fun main() {
    val s = "abcdebdde"
    val t = "bde"
    val s1 = "fgrqsqsnodwmxzkzxwqegkndaa"
    val t1 = "kzed"
    println(minWindow(s1, t1))
}