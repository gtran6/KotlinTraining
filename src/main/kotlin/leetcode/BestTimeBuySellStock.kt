package leetcode

fun maxProfit2(arr: IntArray?): Int {
    var minPrice = Int.MAX_VALUE // This ensures that the first price encountered in the array will always be smaller than minPrice.
    var max = 0

    for (i in 0 until arr!!.size) {
        if (arr[i] < minPrice) {
            minPrice = arr[i]
        } else if (arr[i] - minPrice > max) {
            max = arr[i] - minPrice
        }
    }
    return max
}
// greedy approach
fun maxProfit3(prices: IntArray): Int {
//The idea is to buy the stock whenever the price is lower than the previous day, and sell it whenever the price
// is higher than the previous day. This way we can make a profit on each transaction. The maximum profit will be the
// sum of all profits made on each transaction.
    var max = 0

    //starts from index 1, since we need to compare each day with the previous day.
    for (i in 1 until prices.size) {
        if (prices[i] > prices[i-1]) {
            max += prices[i] - prices[i-1]
        }
    }
    return max
}

fun maxProfit4(prices: IntArray): Int {
    //The key insight is that if we split the problem at some index i, then we can compute the maximum profit
// we can make from day 0 to day i, and the maximum profit we can make from day i to day n-1 independently of
// each other. We can then combine the solutions to these two sub-problems to find the maximum profit we can make
// by buying and selling the stock at most twice.

    // if we make two transactions to buy and sell a stock at some indices i and j (i < j), then either the second
// transaction occurs after index j or it occurs between indices i and j. If it occurs after index j, then the
// maximum profit we can make is simply the sum of the maximum profit we can make from day 0 to day j and the maximum
// profit we can make from day j+1 to day n-1. If it occurs between indices i and j, then we can split the problem
// into two sub-problems as described above.

    /*
    By splitting the problem into two sub-problems, we can solve each sub-problem using dynamic programming independently
    of the other sub-problem. This allows us to reuse the solutions to the sub-problems efficiently and avoid recomputing
    the same sub-problems multiple times.
     */

    // first pass: calculate max profit from left to right
    /*
    When we iterate over the input array from left to right, we can keep track of the minimum price we have seen so far
    and the maximum profit we can make by selling the stock at the current price. This allows us to compute the maximum
    profit we can make from day 0 to day i for each index i.
     */
    val n = prices.size
    //This line initializes a new integer array leftProfit of length n. This array will store the maximum profit that
    // can be obtained by making a single transaction from the beginning up to day i, where i is the index in the array.
    val leftProfit = IntArray(n)
    var minPrice = prices[0]
    for (i in 1 until n) {
        leftProfit[i] = maxOf(leftProfit[i-1], prices[i] - minPrice)
        minPrice = minOf(minPrice, prices[i])
    }

    // second pass: calculate max profit from right to left
    /*
    When we iterate over the input array from right to left, we can keep track of the maximum price we have seen so far
    and the maximum profit we can make by buying the stock at the current price and selling it at the maximum price seen
    so far. This allows us to compute the maximum profit we can make from day i to day n-1 for each index i.
     */
    val rightProfit = IntArray(n)
    var maxPrice = prices[n-1]
    for (i in n-2 downTo 0) {
        rightProfit[i] = maxOf(rightProfit[i+1], maxPrice - prices[i])
        maxPrice = maxOf(maxPrice, prices[i])
    }

    var maxProfit = 0
    for (i in 0 until n) {
        maxProfit = maxOf(maxProfit, leftProfit[i] + rightProfit[i])
    }
    return maxProfit
}
fun main() {
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)
    val maxProfit1 = maxProfit2(prices)
    val maxProfit2 = maxProfit3(prices)
    println(maxProfit1)
    println(maxProfit2)

    val prices2 = intArrayOf(3,3,5,0,0,3,1,4)
    val maxProfit3 = maxProfit4(prices2)
    println(maxProfit3)
}