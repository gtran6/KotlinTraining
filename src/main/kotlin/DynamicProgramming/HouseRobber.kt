package DynamicProgramming

fun rob(nums: IntArray) : Int {
    //Initialize two variables rob and notRob to 0.
    var rob = 0
    var notRob = 0
    /*
    For each house in the neighborhood:

    Calculate the maximum amount that can be stolen if the current house is robbed (which is the
    sum of the current house's value and the amount that can be stolen from the house two
    positions before).

    Calculate the maximum amount that can be stolen if the current house is not robbed (which is
    the maximum amount that can be stolen from the previous house, considering both robbery and
    non-robbery scenarios).

    Update rob and notRob accordingly.
     */
    nums.forEach {
        val currRob = notRob + it
        notRob = maxOf(notRob, rob)
        rob = currRob
    }
    return maxOf(rob, notRob)
}
fun main() {
    val nums = intArrayOf(2,7,9,3,1)
    println(rob(nums))
}