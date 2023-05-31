package DynamicProgramming

fun lengthOfLIS(nums: IntArray): Int {
    val dp = IntArray(nums.size){1}
    for(i in nums.size-1 downTo 0){
        for(j in i+1 until nums.size){
            if(nums[i] < nums[j]){
                dp[i] = maxOf(dp[i], 1 + dp[j])
            }
        }
    }
    var max = 0
    for(n in dp)
        max = maxOf(max, n)
    return max
}
fun main() {
    val nums = intArrayOf(10,9,2,5,3,7,101,18)
    println(lengthOfLIS(nums))
}