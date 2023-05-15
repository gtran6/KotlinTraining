package TwoPointers

fun maxArea(height: IntArray): Int {
    var low = 0
    var high = height.size - 1
    var max = 0

    while (low < high) {
        val width = high - low
        val area = minOf(height[low], height[high]) * width
        max = maxOf(max, area)

        if (height[low] < height[high]) low++
        else high--
    }
    return max
}
fun main() {
    val height = intArrayOf(1,8,6,2,5,4,8,3,7)
    println(maxArea(height))
}