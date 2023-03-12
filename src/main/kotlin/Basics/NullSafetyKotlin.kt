package Basics

fun main() {
    var topic: String? = "kotlin"
    println(topic)

    //1. null check
    if (topic != null) {
        println(topic.length)
    }

    //2. using null safety operator to find the length
    println(topic?.length)
}