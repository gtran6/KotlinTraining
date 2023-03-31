package SlidingWindow

fun minSubarrayLen(nums: IntArray, target: Int) : Int {
    var min = 0
    var start = 0
    var windowLen = Int.MAX_VALUE
    var end = 0

    while (end < nums.size) {
        min += nums[end]

        while (min >= target) {
            windowLen = minOf(windowLen, end - start + 1)
            min -= nums[start]
            start++
        }
        end++
    }
    return if (windowLen == Int.MAX_VALUE) 0 else windowLen
}
fun main() {
    val nums = intArrayOf(2,3,1,2,4,3)
    val target = 7
    println(minSubarrayLen(nums, target))
}

/*
1. We use the window_size variable to store the size of the minimum subarray, initializing it to positive infinity.

2. We use a start variable to track the left end of the subarray. Initially, we’ll set it to 0.

3. We loop over the input array using an end variable to track the right end of the subarray. In each iteration,
we add the value that has just entered the window to the running sum of the window contents.

4. If the sum of our current subarray exceeds or equals the target value, we’ll compare the current subarray size
with the window size already present. The smaller of the two values will be stored in window_size. We then try to
find a smaller subarray that meets the same condition. We slide the starting point of the subarray forward and
check the sum from that point to the end of the subarray, checking the condition and updating window_size where applicable.

5. We repeat the process until the end of the array is reached. If the required minimum subarray is present, we return its length.
 */