package leetcode.SearchEngine

fun breakQuery(query: String, dict: Array<String>) : Boolean {
    val dictSet = HashSet(listOf(*dict))
    val dp = BooleanArray(query.length+1)
    dp[0] = true
    for (i in 1..query.length) {
        for (j in 0 until i) {
            if (dp[j] && dictSet.contains(query.substring(j, i))) {
                dp[i] = true
            }
        }
    }
    return dp[query.length]
}
fun main() {
    val query = "veganicetea"
    val dict = arrayOf("i", "cream", "cook", "scream", "ice", "cat", "book", "icecream", "vegan")
    println(breakQuery(query, dict))
}