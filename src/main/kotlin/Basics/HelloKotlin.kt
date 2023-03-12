package Basics

fun sayHello(greeting: String, itemToGreet: String) = println("$greeting $itemToGreet")

fun main() {
    val interestingThings = arrayOf("kotlin", "programming", "comic books")

    val map = mapOf(1 to "a", 2 to "b", 3 to "c")
    map.forEach {key, value ->
        println("$key -> $value")
    }
}