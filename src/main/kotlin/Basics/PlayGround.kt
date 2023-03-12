package Basics

fun main() {
    //println(fruits.size)
    println("size of the list is ${fruits.size}")

    fruits.forEach{
        i-> println("this is $i")
    }
    fruits.add("orange")
    println(fruits)
    println("size of the list is ${fruits.size}")
}

val fruits : MutableList<String> = mutableListOf("banana", "apple", "mango")