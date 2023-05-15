package binarysearch

import kotlin.math.ceil

//The implementation uses a binary search algorithm to efficiently search for the minimum eating speed within a certain range of speeds.
// The main focus is to optimize the search for the minimum eating speed using binary search, ensuring that Koko can finish within the given time.
fun minEatingSpeed(piles: IntArray, h: Int): Int {
    var left = 1
    var right = 1

    for (pile in piles) {
        right = maxOf(right, pile)
    }

    // uses binary search to find the minimum value of k that satisfies the condition,
    while (left < right) {
        val mid = left + (right - left) / 2

        if (canFinish(piles, h, mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}
//checks whether Koko can finish eating all the bananas within h hours for a given value of k.
fun canFinish(piles: IntArray, h: Int, speed: Int) : Boolean {
    var sum = 0

    for (pile in piles) {
        sum += ceil(pile/speed.toDouble()).toInt()

        if (sum > h) return false
    }
    return true
}
fun main() {
    val piles = intArrayOf(30,11,23,4,20)
    val h = 5
    println(minEatingSpeed(piles, h))
}