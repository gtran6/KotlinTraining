package leetcode.OperatingSystem

/*
First, we’ll use a hashmap to store the cumulative sums and the count of how many times the same sum occurs.
We will treat the sum as the key and the count as its corresponding value. A single entry will be in the
(cumSum[i], count of cumSum[i]) format.

Next, we’ll traverse over the array and compute the cumulative sum at each index. We will make an entry into
the hashmap every time a new sum occurs and assign it the count value 1. If a sum repeats, increment the count value by 1.

In addition to the previous step, we’ll compute cumSum - n at each index; this will determine the number of
times a subarray with a sum of n has occurred. We will also increment the count, the number of times n was found.

Finally, return the count after the array has been traversed.
 */

fun AllocateSpace(processes: IntArray, new_p: Int): Int {
    var count = 0
    var sum = 0
    val map: MutableMap<Int, Int> = HashMap()
    map[0] = 1
    for (i in processes.indices) {
        sum += processes[i]
        if (map.containsKey(sum-new_p))
            count += map[sum-new_p]!!
        map[sum] = map.getOrDefault(sum, 0) + 1
    }
    return count
}
fun main() {
    val processes = intArrayOf(1, 2, 3, 4, 5, 6, 7, 1, 23, 21, 3, 1, 2, 1, 1, 1, 1, 1, 12, 2, 3, 2, 3, 2, 2)
    println(AllocateSpace(processes, 7))
}