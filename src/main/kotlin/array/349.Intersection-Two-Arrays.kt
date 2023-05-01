package array

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val list1 = nums1.toMutableList()
    val list2 = nums2.toMutableList()
    val res = mutableSetOf<Int>()
    for (num in nums1) {
        if (list2.contains(num)) {
            res.add(num)
            list2.remove(num)
        }
    }
    return res.toIntArray()
}
fun main() {
    val nums1 = intArrayOf(4,9,5)
    val nums2 = intArrayOf(9,4,9,8,4)
    println(intersection(nums1, nums2).contentToString())
}