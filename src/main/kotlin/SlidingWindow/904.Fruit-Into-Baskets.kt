package SlidingWindow

fun totalFruit(fruits: IntArray): Int {
    var left = 0
    var right = 0
    val map = mutableMapOf<Int, Int>()
    var max = 0

    while (right < fruits.size) {
        val rightFruit = fruits[right]
        map[rightFruit] = map.getOrDefault(rightFruit, 0) + 1
        right++

        while (map.size > 2) {
            val leftFruit = fruits[left]
            map[leftFruit] = map[leftFruit]!! - 1

            if (map[leftFruit] == 0) {
                map.remove(leftFruit)
            }
            left++
        }
        max = maxOf(max, right - left)
    }
    return max
}
fun main() {
    val fruits = intArrayOf(1,2,3,2,2)
    println(totalFruit(fruits))
}