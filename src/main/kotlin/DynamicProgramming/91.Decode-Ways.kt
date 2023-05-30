package DynamicProgramming

fun numDecodings(s: String): Int {
    val n = s.length
    val dp = IntArray(n + 1)

    // Initialize base cases
    dp[0] = 1
    dp[1] = if (s[0] == '0') 0 else 1

    for (i in 2..n) {
        val oneDigit = s.substring(i - 1, i).toInt()
        val twoDigits = s.substring(i - 2, i).toInt()

        if (oneDigit in 1..9)
            dp[i] += dp[i - 1]

        if (twoDigits in 10..26)
            dp[i] += dp[i - 2]
    }

    return dp[n]
}
fun main() {
    val s = "226"
    println(numDecodings(s))
}