package SlidingWindow

fun maxProfit(prices: IntArray) : Int {
    var minPrice = Int.MAX_VALUE
    var max = 0

    for (i in prices.indices) {
        if (prices[i] < minPrice) minPrice = prices[i]
        else if (prices[i] - minPrice > max) max = prices[i] - minPrice
    }
    return max
}
fun main() {
    val prices = intArrayOf(7,1,5,3,6,4)
    println(maxProfit(prices))
}