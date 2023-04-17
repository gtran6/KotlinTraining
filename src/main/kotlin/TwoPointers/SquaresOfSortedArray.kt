package TwoPointers

fun sortedSquares(nums: IntArray): IntArray {
    return nums.map { it*it }.sorted().toIntArray()
}
fun main() {
    val nums = intArrayOf(-4,-1,0,3,10)
    println(sortedSquares(nums))
}