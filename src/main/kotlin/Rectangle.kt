import kotlin.random.Random

class Rectangle(
    val a: Double,
    val b: Double
) : Shape("Rectangle") {
    companion object {
        fun randomRectangle() : Rectangle {
            val a = Random.nextDouble()
            val b = Random.nextDouble()
            return Rectangle(a, b)
        }
    }

    constructor(a: Double) : this(a, a) // secondary constructor

    constructor(a: Int, b: Int) : this(a.toDouble(), b.toDouble()) // secondary constructor
    init {
        println("$name created with a = $a and b = $b")
        println("rectangle area is ${area()}")
        println("perimeter is ${perimeter()}")
        println("is rectangle a square? ${isSquare()}")
    }

    override fun area() = a*b

    override fun perimeter() = 2*a + 2*b
    fun isSquare() = a == b
}