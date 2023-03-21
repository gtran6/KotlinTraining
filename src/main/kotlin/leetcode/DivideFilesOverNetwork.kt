package leetcode

fun partitionLabels(files: String) : Int {
    //creates a new integer array of size 26, with all elements initialized to the default value of 0
    //This is useful if we want to create an array with a fixed size but do not yet know what the values of its elements should be.
    //we need to create an array to keep track of the last occurrence index of each letter in the input string. We know that there
    // are 26 letters in the English alphabet, so we need an array of size 26 to hold this information.
    val last = IntArray(26) // store the last occurrence index of each letter in the input string
    for (i in 0 until files.length) {
        last[files[i] - 'a'] = i // store the last occurrence index of each letter in the input string
    }
    // used to keep track of the highest last occurrence index encountered so far
    var end = 0
    // will be used to count the number of partitions
    var count = 0

    for (i in 0 until files.length) {
        end = maxOf(end, last[files[i] - 'a'])

        if (end == i) {
            count++
        }
    }
    return count
}
fun main() {
    val files = "abacdc"
    println(partitionLabels(files))
}