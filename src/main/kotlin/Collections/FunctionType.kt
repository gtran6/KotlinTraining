package Collections

// function type: (Int) -> Int
fun main() {
    val number: Int = 5
    val triple: (Int) -> Int = {a: Int -> a * 3}
    println(triple(7))
}