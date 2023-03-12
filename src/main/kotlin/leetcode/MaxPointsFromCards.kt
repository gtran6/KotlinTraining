package leetcode

internal object Solution3 {
    fun maxPoints(deck: IntArray, k: Int) : Int {
        var maxPoints = 0
        var currPoints = 0
        var left = 0
        var right = deck.size - k

        // assume the k cards on the right side give the max points
        for (i in right until deck.size) {
            currPoints += deck[i]
        }
        // update the max points
        maxPoints = currPoints

        // sliding window and update max points
        for (i in 0 until k) {
            currPoints += deck[left] - deck[right]
            maxPoints = maxOf(maxPoints, currPoints)
            left += 1
            right += 1
        }
        return maxPoints
    }
}
fun main() {
    val deck = intArrayOf(5, 3, 4, 4, 2, 3, 2, 6, 3)
    val k = 4
    println(Solution3.maxPoints(deck, k))
}