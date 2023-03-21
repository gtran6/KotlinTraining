package leetcode.Facebook

fun FindStoryId(arr: IntArray, key: Int): Int {
    return Search(arr, 0, arr.size - 1, key)
}

fun Search(arr: IntArray, start: Int, end: Int, key: Int): Int {
    if (start > end) return -1

    val mid = start + (end - start) / 2
    if (arr[mid] == key) return mid

    if (arr[start] <= arr[mid] && key <= arr[mid] && key >= arr[start]) {
        return Search(arr, start, mid-1, key)
    } else if (arr[mid] <= arr[end] && key >= arr[mid] && key <= arr[end]) {
        return Search(arr, mid + 1, end, key)
    } else if (arr[end] <= arr[mid]) {
        return Search(arr, mid+1, end, key)
    } else if (arr[start] >= arr[mid]) {
        return Search(arr, start, mid-1, key)
    }
    return -1
}
fun main() {
    val arr = intArrayOf(6,7,1,2,3,4,5)
    val key = 7
    println(FindStoryId(arr, key))
}