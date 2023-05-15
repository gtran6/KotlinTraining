package TwoPointers

fun trap(height: IntArray): Int {
    var left = 0
    var right = height.size - 1
    var maxLeft = 0
    var maxRight = 0
    var count = 0

    while (left < right) {
        if (height[left] < height[right]) {
            if (height[left] < maxLeft) {
                count += maxLeft - height[left]
            } else {
                maxLeft = height[left]
            }
            left++
        } else {
            if (height[right] < maxRight) {
                count += maxRight - height[right]
            } else {
                maxRight = height[right]
            }
            right--
        }
    }
    return count
}
fun main() {
    val height = intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)
    println(trap(height))
}