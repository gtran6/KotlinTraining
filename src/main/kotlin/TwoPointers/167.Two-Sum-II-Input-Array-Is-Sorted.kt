package TwoPointers

fun twoSum2(numbers: IntArray, target: Int): IntArray {
    var start = 0
    var end = numbers.size - 1

    while (start < end) {
        val sum = numbers[start] + numbers[end]
        if (sum == target) {
            return intArrayOf(start + 1, end + 1)
        } else if (sum < target) {
            start++
        } else {
            end--
        }
    }
    return intArrayOf(-1, -1)
}
fun main() {
    val numbers = intArrayOf(-1,0,1,2)
    val target = 3
    println(twoSum2(numbers, target).contentToString())
}