fun main() {
    val numbers = listOf(1,2,3,4,5,9,13,26,12)
    println(numbers.map { it * 2})
    println(numbers.filter { it % 2 == 0 })
    println(numbers.sorted())
    println(numbers.groupBy { it in 0 until 9 })
    println(addNumbers(3,4))

    val color = "red"
    when (color) {
        "red" -> println(true)
        "blue" -> println(false)
    }

    var name: String? = "Giang"
    println(name?.length)
    println(name!!.length)

    val numbersList = setOf(1, 2, 3, 3, 4, 2, 5)
    println(numbersList)

    println(reverseString("Giang Tran"))
    println(isPalindrome("GianggnaiG"))

    val arr = intArrayOf(1,1,2,3,3,4,5,6,6,7)
    println(removeDuplicate(arr))

    val s = "Giang Tran Giang"
    println(countWords(s))
}
fun addNumbers(a: Int, b: Int) = a+b

fun reverseString(str: String) : String {
    return str.reversed()
}
fun isPalindrome(s: String) : Boolean {
    return s == s.reversed()
}
fun removeDuplicate(arr: IntArray) : IntArray {
    return arr.distinct().toIntArray()
}
fun countWords(s: String) : Map<String, Int> {
    return s.split(" ").groupingBy { it }.eachCount()
}