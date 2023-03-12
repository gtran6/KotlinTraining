package Basics

fun main() {
    val myFirstDice = Dice()
    println(myFirstDice.sides)
    myFirstDice.sides
}
class Dice {
    var sides = 4
    fun roll() {
        val randomNumber = (1..6).random()
        println(randomNumber)
    }
}