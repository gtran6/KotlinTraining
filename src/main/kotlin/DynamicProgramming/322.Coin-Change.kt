package DynamicProgramming

fun coinChange(coins: IntArray, amount: Int): Int {
    val dp = IntArray(amount + 1) { amount + 1 }
    dp[0] = 0

    for (i in 1..amount) {
        for (coin in coins) {
            if (coin <= i) {
                dp[i] = minOf(dp[i], 1 + dp[i - coin])
            }
        }
    }

    return if (dp[amount] > amount) -1 else dp[amount]
}
fun main() {
    val coins = intArrayOf(1,2,5)
    val amount = 11
    println(coinChange(coins, amount))
}