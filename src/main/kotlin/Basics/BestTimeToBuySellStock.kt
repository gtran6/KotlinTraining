package Basics

fun maxProfit(prices: IntArray): Int {
    var min = prices[0]
    var profit = 0
    for (price in prices) {
        min = Math.min(min, price)
        profit = Math.max(profit, price - min)
    }
    return profit
}

fun main() {
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)
    val prices2 = intArrayOf(7, 6, 4, 3, 1)
    println(maxProfit(prices))
    println(maxProfit(prices2))
}