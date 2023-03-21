package leetcode.Netflix

import java.util.PriorityQueue

/*
We will assume that ‘x’ is the median age of a user in a list. Half of the ages in the list will
be smaller than (or equal to) ‘x’, and the other half will be greater than (or equal to) ‘x’.
We can divide the list into two halves: one half to store the smaller numbers (say smallList),
and one half to store the larger numbers (say largeList). The median of all ages will either be
the largest number in the smallList or the smallest number in the largeList. If the total number
of elements is even, we know that the median will be the average of these two numbers. The best
 data structure for finding the smallest or largest number among a list of numbers is a Heap.
 */
internal class Solution {
    // First, we will store the first half of the numbers (smallList) in a Max Heap. We use a Max
    // Heap because we want to know the largest number in the first half of the list.
    var maxHeap: PriorityQueue<Int> = PriorityQueue { a: Int, b: Int -> b - a }

    // Then, we will store the second half of the numbers (largeList) in a Min Heap, because we
    // want to know the smallest number in the second half of the list.
    var minHeap: PriorityQueue<Int> = PriorityQueue { a: Int, b: Int -> a - b }
    fun insertNum(num: Int) {

        if (maxHeap.isEmpty() || maxHeap.peek() >= num) maxHeap.add(num) else minHeap.add(num)

        if (maxHeap.size > minHeap.size + 1)
            minHeap.add(maxHeap.poll()) // This helps ensure that the max heap always has at most one more element than the min heap.
        else if (maxHeap.size < minHeap.size)
            maxHeap.add(minHeap.poll()) // This helps ensure that the min heap always has at most the same number of elements as the max heap.
    }

    fun findMedian(): Double {
        return if (maxHeap.size == minHeap.size) {
            // we have even number of elements, take the average of middle two elements
            maxHeap.peek() / 2.0 + minHeap.peek() / 2.0
        } else { // because max-heap will have one more element than the min-heap
            maxHeap.peek().toDouble()
        }
    }
}

fun main() {
    val medianOfAges = Solution()
    medianOfAges.insertNum(22)
    medianOfAges.insertNum(35)
    println("The recommended content will be for ages under: " + medianOfAges.findMedian())
    medianOfAges.insertNum(30)
    println("The recommended content will be for ages under: " + medianOfAges.findMedian())
    medianOfAges.insertNum(25)
    println("The recommended content will be for ages under: " + medianOfAges.findMedian())
}