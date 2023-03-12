package Basics

fun main() {
    var firstnum = 1
    var secondnum = 2

    var temp = firstnum
    firstnum = secondnum
    secondnum = temp

    println("first number after swapping: $firstnum")
    println("second number after swapping: $secondnum")
}