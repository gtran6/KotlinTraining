package array

fun getSecondLargest(arr: IntArray) : Int {
    var largest = if (arr[1] > arr[0]) arr[1] else arr[0]
    var secondLargest = if (arr[1] > arr[0]) arr[0] else arr[1]

    for (i in 2 until arr.size) {
        if (arr[i] > largest) {
            secondLargest = largest
            largest = arr[i]
        } else if (arr[i] > secondLargest) {
            arr[i] = secondLargest
        }
    }
    return secondLargest
}
fun main() {
    val arr = intArrayOf(4, -7, 5, 1)
    println(getSecondLargest(arr))
}