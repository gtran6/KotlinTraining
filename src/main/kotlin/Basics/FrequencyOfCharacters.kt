package Basics

fun main() {
    val string = "kotlin training"
    val c = 'e'
    var count = 0

    for (i in 0..string.length - 1) {
        if (c == string[i]) {
            count++
        }
    }

    println("Frequency of character $c is $count")
}