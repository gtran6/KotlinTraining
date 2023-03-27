package Basics

class CompanionObject {
    companion object {
        const val PI = 3.14

        fun great() {
            println("Hello")
        }
    }
}

fun main() {
    CompanionObject.great() // calling a function from companion object
    println(CompanionObject.PI) // accessing a variable from companion object
}