package array

// time limit exceed
fun longestConsecutive(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var max = 0

    for (num in nums) {
        var currentMax = 1
        var currentNum = num
        while (currentNum + 1 in nums) {
            currentNum += 1
            currentMax += 1
        }
        max = maxOf(max, currentMax)
    }
    return max
}

// a time complexity of O(n) since each element is visited only once, and the HashSet operations are performed in constant time.
fun longestConsecutive1(nums: IntArray): Int {
    val set = nums.toSet()
    var max = 0

    //we iterate through each element of the set. For each element, we check if num - 1 is not present in the set.
    // If it is not present, it means that num is the start of a potential consecutive sequence.
    for (num in set) {
        if (!set.contains(num-1)) {
            var currNum = num
            var currMax = 1

            while (currNum + 1 in set) {
                currNum += 1
                currMax += 1
            }
            max = maxOf(max, currMax)
        }
    }
    return max
}
fun main() {
    val nums = intArrayOf(100,4,200,1,3,2)
    println(longestConsecutive1(nums))
}