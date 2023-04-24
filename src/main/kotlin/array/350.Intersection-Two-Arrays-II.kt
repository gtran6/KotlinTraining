package array

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val list1 = nums1.toMutableList()
    val list2 = nums2.toMutableList()
    var res: MutableList<Int> = mutableListOf()
    for (num in nums1) {
        if (list2.contains(num)) {
            res.add(num)
            list2.remove(num)
        }
    }
    return res.toIntArray()
}
fun main() {
    val nums1 = intArrayOf(1,2,2,1)
    val nums2 = intArrayOf(2,2)
    println(intersect(nums1, nums2))
}