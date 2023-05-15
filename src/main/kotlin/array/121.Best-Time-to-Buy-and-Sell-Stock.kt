package array

fun maxProfit(prices: IntArray): Int {
    var max = 0
    var minPrice = Int.MAX_VALUE

    for (price in prices) {
        if (price < minPrice) minPrice = price
        else if (price - minPrice > max) max = price - minPrice
    }
    return max
}
fun main() {
    val prices = intArrayOf(7,1,5,3,6,4)
    println(maxProfit(prices))
}