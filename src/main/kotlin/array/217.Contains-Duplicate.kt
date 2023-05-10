package array

fun containsDuplicate(nums: IntArray): Boolean {
    val set = HashSet<Int>()
    nums.forEach { num ->
        if (!set.add(num)) return true // it means that the element is already present in the set and thus a duplicate has been found
    }
    return false
}
fun main() {
    val nums = intArrayOf(1,1,1,3,3,4,3,2,4,2)
    println(containsDuplicate(nums))
}