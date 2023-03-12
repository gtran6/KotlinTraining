package leetcode

import java.util.TreeMap

internal object Solution2 {
    fun isHandOfStraights(hand: IntArray, k: Int) : Boolean {
        if (hand.size % k != 0) return false

        val count = TreeMap<Int, Int>()
        for (card in hand) {
            count[card] = count.getOrDefault(card, 0) + 1
        }

        while (count.isNotEmpty()) {
            val startCard = count.firstKey()
            // check all the cards in the current group for consecutive cards.
            for (card in startCard until startCard+k) {
                // get the count of the current card from the 'count' map, or returns a default value of 0 if card is not present in the map
                val currentCount = count.getOrDefault(card, 0)
                if (currentCount == 0) return false
                //If the currentCount of the current card is 1, this means that it is the last instance of this card in the current group.
                // In this case, we can remove the card from 'count', since it has been fully grouped into a set of consecutive cards.
                // Otherwise, if the currentCount is greater than 1, we decrement the count of the card in 'count', indicating that
                // it is part of a larger group of consecutive cards.
                if (currentCount == 1) {
                    count.remove(card)
                } else {
                    count[card] = currentCount - 1
                }
            }
        }
        return true
    }
}

fun main() {
    var hand = intArrayOf(5, 2, 4, 4, 1, 3, 5, 5, 3)
    var k = 3
    println(Solution2.isHandOfStraights(hand, k))
    hand = intArrayOf(1, 9, 3, 5, 7, 4, 2, 9, 11)
    k = 2
    println(Solution2.isHandOfStraights(hand, k))
}