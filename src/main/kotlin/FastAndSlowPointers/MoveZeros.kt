package FastAndSlowPointers

fun moveZeroes(nums: IntArray): Unit {
    var readIndex = 0
    var writeIndex = 0
     while (readIndex < nums.size) {
         if (nums[readIndex] != 0) {
             nums[writeIndex] = nums[readIndex]
             writeIndex++
         }
         readIndex++
     }
    while (writeIndex < nums.size) {
        nums[writeIndex] = 0
        writeIndex++
    }
}
fun main() {
    val nums = intArrayOf(0,1,0,3,12)
    println(moveZeroes(nums))
}