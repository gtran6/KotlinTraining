package TwoPointers
/*
If the sum of the triplet is equal to the target, we return TRUE. Otherwise, we continue.

If the sum of the triplet is less than the target, we move the low pointer forward, that is,
towards the end. The aim is to increase the value of the sum so that it gets closer or equal to the target value.

If the sum of the triplet is greater than the target, we move the high pointer towards the start.
The aim is to reduce the value of the sum so that it gets closer or equal to the target value.
 */
fun findSumOfThree(nums: IntArray, target: Int) : Boolean {
    val newArray = nums.sortedArray()

    for (i in 0 until newArray.size-2) {
        var low = i+1
        var high = newArray.size - 1

        while (low < high) {
            val triplet = newArray[i] + newArray[low] + newArray[high]
            if (triplet == target) {
                return true
            } else if (triplet < target) {
                low++
            } else {
                high--
            }
        }
    }
    return false
}
fun main() {
    val nums = intArrayOf(2, 3, 4, 1, 7, 9)
    val target = 20
    println(findSumOfThree(nums, target))
}