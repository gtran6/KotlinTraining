package array

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
/*    val list1 = nums1.toMutableList()
    val list2 = nums2.toMutableList()
    var res: MutableList<Int> = mutableListOf()
    for (num in nums1) {
        if (list2.contains(num)) {
            res.add(num)
            list2.remove(num)
        }
    }
    return res.toIntArray()*/

    //What if the given array is already sorted? How would you optimize your algorithm?
    nums1.sort()
    nums2.sort()
    val res = mutableListOf<Int>()
    var i = 0
    var j = 0
    while (i < nums1.size && j < nums2.size) {
        if (nums1[i] < nums2[j]) i++
        else if (nums1[i] > nums2[j]) j++
        else {
            res.add(nums1[i])
            i++
            j++
        }
    }
    return res.toIntArray()
}
fun main() {
    val nums1 = intArrayOf(1,1,2,2)
    val nums2 = intArrayOf(2,2)
    println(intersect(nums1, nums2))
}