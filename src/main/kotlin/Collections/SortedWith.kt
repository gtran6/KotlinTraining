package Collections

fun main() {
    val peopleNames = listOf("Fred", "Ann", "Barbara", "Joe")
    println(peopleNames.sorted())
    println(peopleNames.sortedWith {
        s1: String, s2: String -> s1.length - s2.length
    })
}