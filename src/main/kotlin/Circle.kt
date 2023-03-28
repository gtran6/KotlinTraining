class Circle(
    val radius: Double
) {
    val pi = 3.141592
    init {
        println("circle created with radius = $radius")
        println("circle area is ${area()}")
        println("circle perimeter is ${perimeter()}")
    }
    fun area() = radius * radius * pi

    fun perimeter() = 2 * radius * pi
}