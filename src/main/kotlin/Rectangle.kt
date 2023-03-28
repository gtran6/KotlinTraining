class Rectangle(
    val a: Double,
    val b: Double
) {
    init {
        println("rectangle created with a = $a and b = $b")
    }

    fun area() = a*b

    fun perimeter() = 2*a + 2*b

    fun isSquare() = a == b
}