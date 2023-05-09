package array

fun findKthLargest(nums: IntArray, k: Int): Int {
    nums.sortDescending()
    if (nums.size <= 1) return nums[0]
    for (i in nums.indices) {
        if (i == k - 1) {
            return nums[i]
        }
    }
    return 0
}
fun findKthLargest1(nums: IntArray, k: Int): Int {
    nums.sort()
    if (nums.size <= 1) return nums[0]
    for (i in 0 until nums.size-1) {
        return nums[nums.size - k]
    }
    return 0
}

// implement the code O(n) time using a selection algorithm QUICKSELECT
fun findKthLargest2(nums: IntArray, k: Int): Int {
    fun swap(i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }

    // Finds the index of the pivot that splits into two partitions
    fun findPivot(start: Int, end: Int): Int {
        // Use random pivot to ensure average time complexity
        val randomPivot = (start..end).random()

        // Move the random pivot to the end to begin partitioning
        swap(randomPivot, end)

        val pivot = nums[end]
        var pivotIndex = start
        for (i in start until end) {
            // Swap the elements anytime a lower than pivot is encountered.
            // Sorting in descending order
            if (nums[i] > pivot) {
                swap(pivotIndex, i)
                pivotIndex++
            }
        }
        // Put the pivot in b/w two partitions
        swap(pivotIndex, end)
        return pivotIndex
    }

    var start = 0
    var end = nums.lastIndex
    var pivotIndex = 0
    // Result is guaranteed to be found
    while (start <= end) {
        pivotIndex = findPivot(start, end)
        // If the pivot index is the Kth largest, result is found
        if (pivotIndex == k - 1) {
            break
        }
        // Else check either partitions but not both
        if (pivotIndex < k) {
            start = pivotIndex + 1
        } else {
            end = pivotIndex - 1
        }
    }
    // Return when the Kth largest is found
    return nums[pivotIndex]
}

fun main() {
    val nums = intArrayOf(3,2,3,1,2,4,5,5,6)
    val k = 4
    println(findKthLargest2(nums, k))
}