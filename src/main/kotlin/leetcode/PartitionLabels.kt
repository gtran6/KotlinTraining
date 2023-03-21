package leetcode

fun partitionLabels1(s: String) : IntArray {
    var last = IntArray(26)
    for (i in 0 until s.length) {
        last[s[i] - 'a'] = i
    }

    var result = mutableListOf<Int>()
    var start = 0
    var end = 0
    for (i in 0 until s.length) {
        end = maxOf(end, last[s[i] - 'a'])
        if (end == i) {
            result.add(end - start + 1)
            //the start pointer is updated to the next index, which is end + 1.
            //This is because the next partition starts immediately after the end of
            //the current partition. This ensures that the start pointer always points
            //to the beginning of the current partition.
            start = end + 1
        }
    }
    return result.toIntArray()
}

fun main() {
    val s = "ccebabdaeddebeaeaaec"
    val result = partitionLabels1(s)
    println(result.contentToString())
}