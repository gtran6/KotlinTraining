package Collections

fun main() {
    val words = listOf("about", "acute", "awesome", "balloon", "best", "brief", "class", "coffee", "creative")
    val filteredWord = words.filter {
        it.startsWith("b", ignoreCase = true)
    }.shuffled().take(2).sorted()
    println(filteredWord)
}