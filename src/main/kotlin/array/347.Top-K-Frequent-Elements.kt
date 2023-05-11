package array

import java.util.*
import kotlin.collections.HashMap

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val res = mutableListOf<Int>()
    val map = mutableMapOf<Int, Int>()

    nums.forEach { num ->
        map[num] = map.getOrDefault(num, 0) + 1
    }

    val freq = MutableList(nums.size + 1) { mutableListOf<Int>() }

    for ((num, frequency) in map) {
        freq[frequency].add(num)
    }

    for (i in freq.size - 1 downTo 0) {
        for (num in freq[i]) {
            res.add(num)

            if (res.size == k) {
                return res.toIntArray()
            }
        }
    }
    return intArrayOf()
}

// min-heap (PriorityQueue) with O(Nlogk)
fun topKFrequent2(nums: IntArray, k: Int): IntArray {
    val frequencyMap = HashMap<Int, Int>()
    for (num in nums) {
        frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
    }

    val minHeap = PriorityQueue<Int> { a, b -> frequencyMap[a]!! - frequencyMap[b]!! }

    for (num in frequencyMap.keys) {
        minHeap.offer(num)
        if (minHeap.size > k) {
            minHeap.poll()
        }
    }

    val topKFrequentList = mutableListOf<Int>()
    while (minHeap.isNotEmpty()) {
        topKFrequentList.add(minHeap.poll())
    }
    topKFrequentList.reverse()

    return topKFrequentList.toIntArray()
}
fun main() {
    val nums = intArrayOf(1,1,1,2,2,3)
    val k = 2
    println(topKFrequent2(nums, k).contentToString())
}
/*

Input: nums = [1,1,1,2,2,3], k = 2

1. res = [], count = {}, freq = [[], [], [], [], [], [], []]

2. res = [], count = {1:3, 2:2, 3:1}, freq = [[], [3], [2], [1], [], [], []]

3. Iterate over freq starting from the end:
   - freq[6] is empty, skip
   - freq[5] is empty, skip
   - freq[4] is empty, skip
   - freq[3] has [1], add 1 to res
   - freq[2] has [2], add 2 to res
   - res has size k, return [1, 2]

 */