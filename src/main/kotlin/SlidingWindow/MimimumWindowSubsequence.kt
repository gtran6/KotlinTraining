package SlidingWindow

fun minWindow(s: String, t: String): String {
    // initialize 2 pointers indexS and indexT to 0 for iterating both strings
    var indexS = 0
    var indexT = 0
    var result = ""
    var length = Int.MAX_VALUE

    while (indexS < s.length) {
        // if the character pointed by indexS in s is the same as the character pointed by indexT in t
        // increment both pointers
        // otherwise only increment indexS
        if (s[indexS] == t[indexT]) {
            indexT++
            /*
            We’ve reached a point where the character in str1 is the same as that of the character in str2.
            Slide both the pointers. We also check at this point whether or not we’ve found a subsequence.
            Since no subsequence has been found yet, we will just slide both the pointers.
             */
            /*
            We've reached a point where every character of str2 appears in str1, in the same order as it is
            present in str2. Slide index_s2. We'll now check the minimum subsequence in the reverse direction.
             */
            if (indexT == t.length) {
                // create two new pointers (start and end) once indexT reaches the end of T
                // with these two pointers, we'll slide the window in the opposite direction
                var start = indexS // set the start to the value of indexS
                var end = indexS + 1 // set the end to indexS + 1
                /*
                Decrement index_s2 if the character pointed by the start pointer in str1 is equal
                to the character pointed to by index_s2 in str2 and decrement the start pointer
                until index_s2 becomes less than zero.
                 */
                indexT--
                while (indexT >= 0) {
                    if (s[start] == t[indexT]) {
                        indexT--
                    }
                    start--
                }
                start++

                //If this length is less than the current minimum length, update the length variable and result string.
                if (end - start < length) {
                    length = end - start //Calculate the length of a substring by subtracting values of the end and start variables.
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