package DynamicProgramming

fun climbStairs(n: Int): Int {
    if (n == 1) return 1 // if it doesn't have this, the function assumes that n is always greater than or equal to 2
    var dp = IntArray(n + 1)
    dp[1] = 1
    dp[2] = 2
    for (i in 3..n) {
        dp[i] = dp[i-1] + dp[i-2]
    }
    return dp[n]
}
fun main() {
    val n = 5
    println(climbStairs(5))
}