package array

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val res = mutableListOf<Int>()
    val map = mutableMapOf<Int, Int>()
    val freq = MutableList<MutableList<Int>>(nums.size + 1) { mutableListOf() }

    nums.forEach { num ->
        map[num] = map.getOrDefault(num, 0) + 1
    }

    for ((num, char) in map) {
        freq[char].add(num)
    }

    for (i in freq.size - 1 downTo  0) {
        for (num in freq[i]) {
            res.add(num)
            if (res.size == k) {
                return res.toIntArray()
            }
        }
    }
    return intArrayOf()
}
fun main() {
    val nums = intArrayOf(1,1,1,2,2,3)
    val k = 2
    println(topKFrequent(nums, k).contentToString())
}