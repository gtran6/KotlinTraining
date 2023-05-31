package DynamicProgramming

fun integerBreak(n: Int): Int {
    val dp = IntArray(n + 1)

    for (i in 2..n) {
        for (j in 1 until i) {
            dp[i] = maxOf(dp[i], maxOf(j * (i - j), j * dp[i - j]))
        }
    }

    return dp[n]
}
fun main() {
    val n = 10
    println(integerBreak(n))
}