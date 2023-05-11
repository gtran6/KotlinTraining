package array

// time limit exceed
fun findMaxLength(nums: IntArray): Int {
    var max = 0

    for (i in nums.indices) {
        var zeroCount = 0
        var oneCount = 0
        for (j in i until nums.size) {
            if (nums[j] == 0) {
                zeroCount++
            }
            else {
                oneCount++
            }
            if (zeroCount == oneCount) {
                max = maxOf(max, j-i+1)
            }
        }
    }
    return max
}

fun findMaxLength1(nums: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    var max = 0
    var count = 0

    // Initialize the map with count=0 at index=-1
    map[0] = -1

    for (i in nums.indices) {
        // Increment count for 1, decrement for 0
        count += if (nums[i] == 1) 1 else - 1 // 0 : -1, 1 : +1


        if (map.contains(count)) {
            // If the count exists in the map, update the max length
            max = maxOf(max, i - map[count]!!)
        } else {
            // Store the count with its corresponding index
            map[count] = i
        }
    }
    return max
}
fun main() {
    val nums = intArrayOf(0, 1, 0, 1, 1, 0)
    println(findMaxLength(nums))
}