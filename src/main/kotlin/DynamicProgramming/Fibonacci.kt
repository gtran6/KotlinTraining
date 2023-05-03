package DynamicProgramming

fun fibonacci(n: Int) : Int {
    if (n == 0 || n == 1) return n
    var a = 0
    var b = 1
    for (i in 2..n) {
        val c = a + b
        a = b
        b = c
    }
    return b
}
fun fib(n: Int): Int {
    if (n == 0) return 0
    if (n == 1) return 1
    return fib(n - 1) + fib(n - 2)
}
fun main() {
    val n = 15
    println(fib(n))
}