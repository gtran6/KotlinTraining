package binarysearch

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val array = mergeTwoArrays(nums1, nums2)

    return if (array.size % 2 == 0) {
        val mid = array.size / 2
        (array[mid - 1] + array[mid]) / 2.0
    } else {
        array[array.size / 2].toDouble()
    }
}

fun mergeTwoArrays(nums1: IntArray, nums2: IntArray): IntArray {
    val merge = IntArray(nums1.size + nums2.size)
    var i = 0
    var j = 0
    var k = 0

    while (i < nums1.size && j < nums2.size) {
        if (nums1[i] <= nums2[j]) {
            merge[k++] = nums1[i++]
        } else {
            merge[k++] = nums2[j++]
        }
    }

    //This while loop handles the remaining elements in nums1 that were not processed in the previous loop.
    // It adds the remaining elements one by one to the merged array and increments both i and k by 1 until
    // nums1 is fully processed.
    while (i < nums1.size) {
        merge[k++] = nums1[i++]
    }

    //Similarly, this while loop handles the remaining elements in nums2 that were not processed in the
    // first loop. It adds the remaining elements one by one to the merged array and increments both
    // j and k by 1 until nums2 is fully processed.
    while (j < nums2.size) {
        merge[k++] = nums2[j++]
    }
    return merge
}
fun main() {
    val nums1 = intArrayOf(1,3)
    val nums2 = intArrayOf(2,4)
    println(findMedianSortedArrays(nums1, nums2))
}
