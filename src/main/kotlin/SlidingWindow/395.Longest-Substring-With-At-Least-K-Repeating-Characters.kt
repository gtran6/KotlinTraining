package SlidingWindow

// brute force with O(n^2)
fun longestSubstring(s: String, k: Int): Int {
    var maxLength = 0

    for (i in s.indices) {
        val counts = IntArray(26)
        for (j in i until s.length) {
            val charIndex = s[j] - 'a'
            counts[charIndex]++

            var valid = true
            for (count in counts) {
                if (count in 1 until k) {
                    valid = false
                    break
                }
            }
            if (valid) {
                maxLength = maxOf(maxLength, j-i+1)
            }
        }
    }
    return maxLength
}

// divide and conquer with O(nlogn)
fun longestSubstring1(s: String, k: Int): Int {
    return longestSubStringUtil(s, 0, s.length, k)
}

fun longestSubStringUtil(s: String, start: Int, end: Int, k: Int): Int {
    if (end < k) return 0
    val count = IntArray(26)

    for (i in start until end) {
        count[s[i] - 'a']++
    }

    for (mid in start until end) {
        if (count[s[mid] - 'a'] >= k) continue
        var midNext = mid + 1

        while (midNext < end && count[s[midNext] - 'a'] < k) {
            midNext++
        }
        return maxOf(longestSubStringUtil(s, start, mid, k), longestSubStringUtil(s, midNext, end, k))
    }
    return end - start
}

/*

- sliding window with O(n)
The main idea is to find all the valid substrings with a different number of unique characters and track
the maximum length. Let's look at the algorithm in detail.

 */
fun longestSubstring2(s: String, k: Int): Int {
    if (k < 1) return s.length

    var max = 0

    for (uniqueTarget in 1..256) {
        val map = IntArray(256)
        var uniqueCnt = 0
        var atLeastK = 0
        var l = 0

        for (r in s.indices) {
            val c = s[r].toInt()

            if (map[c] == 0) {
                uniqueCnt++
            }

            map[c]++

            if (map[c] == k) {
                atLeastK++
            }

            while (uniqueCnt > uniqueTarget) {
                val z = s[l].toInt()

                if (map[z] == k) {
                    atLeastK--
                }
                map[z]--

                if (map[z] == 0) {
                    uniqueCnt--
                }
                l++
            }

            if (uniqueCnt == uniqueTarget && atLeastK == uniqueTarget) {
                max = maxOf(max, r - l + 1);
            }
        }
    }
    return max
}

fun main() {
    val s = "bbaaacbd"
    val k = 3
    println(longestSubstring1(s, k)) // 3: aaa
}