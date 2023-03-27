package leetcode.SearchEngine

fun stringBreak(s: String, subs: List<String>): Boolean {
    // create a hash set of substrings for faster lookup
    val subSet = HashSet(subs)
    // initialize a boolean array to keep track of whether each index in s can be broken down
    val dp = BooleanArray(s.length+1)
    // set the first index to true
    dp[0] = true
    // iterate through each index of s
    for (i in 1..s.length) {
        // iterate through each possible break point before the current index
        for (j in 0 until i) {
            // check if the substring between the break point and the current index is in the hashset
            if (dp[j] && subSet.contains(s.substring(j, i))) {
                // if it is, mark the current index as true
                dp[i] = true
                break
            }
        }
    }
    // represent whether the entire string s can be broken down into the substrings in subSet
    return dp[s.length]
}
fun main() {
    val s = "magically"
    val subs = listOf("ag", "al", "icl", "mag", "magic", "ly", "lly")
    println(stringBreak(s, subs))
}