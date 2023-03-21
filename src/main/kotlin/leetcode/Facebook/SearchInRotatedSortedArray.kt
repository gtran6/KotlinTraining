package leetcode.Facebook

fun searchRotated(arr:List<Int>,key:Int) : Int {
    return Search2(arr, 0, arr.size-1, key)
}

fun Search2(arr: List<Int>, start: Int, end: Int, key: Int): Int {
    if (start > end) return -1
    val mid = start + (end - start) / 2
    if (arr[mid] == key) return mid

    if (key <= arr[mid] && arr[start] <= arr[mid] && key >= arr[start]) {
        return Search2(arr, start, mid-1, key)
    } else if (key >= arr[mid] && key <= arr[end] && arr[mid] <= arr[end]) {
        return Search2(arr, mid+1, end, key)
    } else if (arr[end] <= arr[mid]) {
        return Search2(arr, mid+1, end, key)
    } else if (arr[start] >= arr[mid]) {
        return Search2(arr, start, mid-1, key)
    }
    return -1
}

fun main() {
    val arr = listOf(3,4,5,6,7,0,1,2)
    val key = 5
    println(searchRotated(arr, key))
}
