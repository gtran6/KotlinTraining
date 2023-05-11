package array

fun productExceptSelf(nums: IntArray): IntArray {
    val res = mutableListOf<Int>()
    var prefix = 1

    // Calculate prefix products
    nums.indices.forEach { i ->
        res.add(prefix)
        prefix += nums[i]
    }

    // Calculate suffix products and combine with prefix products
    var postfix = 1
    (nums.size-1 downTo 0).forEach { i ->
        res[i] *= postfix
        postfix *= nums[i]
    }
    return res.toIntArray()
}
fun main() {
    val nums = intArrayOf(-1,1,0,-3,3)
    println(productExceptSelf(nums).contentToString())
}