fun longestConsecutive(nums: IntArray): Int {
    val map: MutableMap<Int, Int> = HashMap()
    var max = 0

    for (num in nums) {
        if (!map.containsKey(num)) {
            val left = map.getOrDefault(num-1, 0)
            val right = map.getOrDefault(num+1, 0)
            val len = left+right+1

            map[num] = len
            map[num-left] = len
            map[num+right] = len
            max = maxOf(max, len)
        }
    }
    return max
}
fun main() {
    val nums = intArrayOf(100,4,200,1,3,2)
    println(longestConsecutive(nums))
}