package SlidingWindow

import java.util.*


fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    if (nums.isEmpty() || k <= 0) return intArrayOf()

    val result = IntArray(nums.size-k+1) // there can be a maximum of nums.size - k + 1 sliding windows in the given array nums.
    // 1. Create a deque to store the indices of the elements in the window.
    val deque = LinkedList<Int>()

    //2. Loop through the array using the variable i as the index.
    for (i in nums.indices) {
        //3. Remove any elements from the deque that are out of the window's range (i.e., their index is less than i-k+1).
        while (deque.isNotEmpty() && deque.peek() < i-k+1) {
            deque.poll()
        }
        //4. Remove any elements from the deque that are smaller than the current element (nums[i]).
        while (deque.isNotEmpty() && nums[deque.peekLast()] < nums[i]) {
            deque.pollLast()
        }
        //5.Add the current element's index (i) to the deque.
        deque.offer(i)
        //6. If i is greater than or equal to k-1 (i.e., the window is full), add the maximum value of the window
        // (i.e., the element at the front of the deque) to the result array.
        if (i >= k-1) {
            result[i-k+1] = nums[deque.peek()]
        }
    }
    return result
}
fun main() {
    val nums = intArrayOf(1,3,-1,-3,5,3,6,7)
    val k = 3
    println(maxSlidingWindow(nums, k))
}