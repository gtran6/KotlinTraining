package leetcode

fun peakIndexInMountainArray(arr: IntArray): Int {
    var left = 0
    var right = arr.size-1

    // 0 1 2 3 0 1
    while (left < right) {
        var mid = (left + right) / 2
        if (arr[mid] < arr[mid+1])
            left = mid + 1
        else
            right = mid
    }
    return left
}
fun main() {
    var arr = intArrayOf(0,10,5,2)
    println(peakIndexInMountainArray(arr))
}