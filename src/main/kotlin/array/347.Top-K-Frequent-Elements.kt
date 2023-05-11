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

    // the less frequent element first
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

fun topKFrequent3(nums: IntArray, k: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for (num in nums) {
        map[num] = map.getOrDefault(num, 0) + 1
    }
    val sorted = map.entries.sortedByDescending { it.value }

    return sorted.take(k).map { it.key }.toIntArray()
}

// QuickSelect with O(n)
fun topKFrequent4(nums: IntArray, k: Int): IntArray {
    val frequencyMap = HashMap<Int, Int>()
    for (num in nums) {
        frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
    }

    val uniqueElements = frequencyMap.keys.toIntArray()
    val n = uniqueElements.size

    val kthLargestFrequency = quickSelect(uniqueElements, frequencyMap, 0, n - 1, n - k)

    val topKFrequentElements = mutableListOf<Int>()
    for (num in uniqueElements) {
        if (frequencyMap[num]!! >= kthLargestFrequency) {
            topKFrequentElements.add(num)
        }
    }

    return topKFrequentElements.toIntArray()
}

fun quickSelect(nums: IntArray, frequencyMap: Map<Int, Int>, left: Int, right: Int, k: Int): Int {
    if (left == right) {
        return frequencyMap[nums[left]]!!
    }

    val pivotIndex = partition(nums, frequencyMap, left, right)

    return when {
        pivotIndex == k -> frequencyMap[nums[pivotIndex]]!!
        pivotIndex < k -> quickSelect(nums, frequencyMap, pivotIndex + 1, right, k)
        else -> quickSelect(nums, frequencyMap, left, pivotIndex - 1, k)
    }
}

fun partition(nums: IntArray, frequencyMap: Map<Int, Int>, left: Int, right: Int): Int {
    val pivotFreq = frequencyMap[nums[right]]!!
    var i = left

    for (j in left until right) {
        if (frequencyMap[nums[j]]!! < pivotFreq) {
            swap(nums, i, j)
            i++
        }
    }

    swap(nums, i, right)

    return i
}

fun swap(nums: IntArray, i: Int, j: Int) {
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}
fun main() {
    val nums = intArrayOf(1,1,1,2,2,3)
    val k = 2
    println(topKFrequent4(nums, k).contentToString())
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