package Basics

fun main() {
    var score:Int = 4

    when {
        score in 1..5 -> {
            println(score)
        }
    }
}