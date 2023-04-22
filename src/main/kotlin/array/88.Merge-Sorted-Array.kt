package array

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var p1 = m - 1 // pointer for nums1
    var p2 = n - 1 // pointer for nums2
    var p = m + n - 1 // pointer for merged array

    while (p1 >= 0 && p2 >= 0) { // iterate over both arrays
        if (nums1[p1] > nums2[p2]) { // if the element in nums1 is greater than nums2
            nums1[p] = nums1[p1] // add nums1 element to merged array
            p1-- // move pointer for nums1
        } else { // if the element in nums2 is greater than nums1 or equal
            nums1[p] = nums2[p2] // add nums2 element to merged array
            p2-- // move pointer for nums2
        }
        p-- // move pointer for merged array
    }

    // If there are any remaining elements in nums2, add them to the beginning of nums1
    while (p2 >= 0) {
        nums1[p] = nums2[p2]
        p2--
        p--
    }
}
fun main() {
    val nums1 = intArrayOf(1,2,3,0,0,0)
    val m = 3
    val nums2 = intArrayOf(2,5,6)
    val n = 3
    println(merge(nums1, m, nums2, n))
}