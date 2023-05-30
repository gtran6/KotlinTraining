package DynamicProgramming

fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val subSet = HashSet(wordDict)
    val dp = BooleanArray(s.length+1)
    dp[0] = true
    for (i in 1..s.length) {
        for (j in 0 until i) {
            if (dp[j] && subSet.contains(s.substring(j,i))) {
                dp[i] = true
                break
            }
        }
    }
    return dp[s.length]
}
fun main() {
    val s = "leetcode"
    val wordDict = listOf("leet","code")
    println(wordBreak(s, wordDict))
}