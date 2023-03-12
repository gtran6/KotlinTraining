package Collections

import java.lang.Math.random

// Lambda is like you wrote a small function in the curly braces, but there's no function name
fun main() {
    val peopleAges = mutableMapOf<String, Int>("Fred" to 30, "Ann" to 23)
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51
    peopleAges["Joe"] = 54

    //peopleAges.forEach { println("${it.key} is ${it.value} ")
}
var i = 20
val j: (Int) -> Int = {i -> i/2}
fun functions(i: Int, operations: (Int) -> Int): Int {
    return operations(i)
}
