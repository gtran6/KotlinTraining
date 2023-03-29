package FastAndSlowPointers

fun circularArrayLoop(nums: IntArray) : Boolean {
    for (i in 0 until nums.size - 1) {
        // If there is a cycle starting at index i, return true
        if (hasCycle(nums,i)) return true
    }
    return false
}

fun hasCycle(nums: IntArray, i: Int): Boolean {
    // Initialize the slow pointer to start at the given index
    var slow = i
    // Initialize the fast pointer to start at the next index
    var fast = nextStep(nums, slow)
    while (slow != fast) {
        if (slow == -1 || fast == -1) return false
        slow = nextStep(nums, slow) // Move the slow pointer one step forward
        fast = nextStep(nums, nextStep(nums, fast)) // Move the fast pointer two steps forward
    }
    return slow != 1
}

fun nextStep(nums: IntArray, curr: Int): Int {
    return if (curr != -1) {
        var new = (curr + nums[curr]) % nums.size //// Calculate the new index based on the current index and value
        if (new < 0) new += nums.size
        if (new != curr && sameSign(nums[curr], nums[new])) new else -1
    } else -1
}

fun sameSign(a: Int, b: Int) = a >= 0 == b >= 0

fun main() {
    val nums = intArrayOf(2,-1,1,2,2)
    println(circularArrayLoop(nums))
}