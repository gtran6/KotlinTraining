package leetcode

fun jump(nums: IntArray?) : Int {
    //if (nums!!.size < 2) return 0
    var hops = 1
    var currMax = nums!![0]
    var max = nums!![0]

    for (i in 1 until nums!!.size) {

        if (currMax < i) {
            hops++
            currMax = max
        }
        max = maxOf(max, nums!![i] + i)
    }
    return hops
}
fun main() {
    val array = intArrayOf(2, 0, 2, 4, 6, 0, 0, 3)
    println(jump(array))
}