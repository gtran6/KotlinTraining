package Collections

// SET is a group of related items, but unlike a list, there can't be any duplicates, and the order doesn't matter
fun main() {
    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    val setOfNumbers = numbers.toSet()
    println(setOfNumbers)
    //println("set: ${setOfNumbers}")
    //println("set: ${numbers.toSet()}")

    //mutable set
    val set1 = mutableSetOf(3,2,1)
    //immutable set
    val set2 = setOf(1,2,3)
    println(set1 == set2)

    println(setOfNumbers.contains(7))
}