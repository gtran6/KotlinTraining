
import java.lang.NumberFormatException
import kotlin.Exception

fun main() {
    /*    val string = "Giang Tran"
    println("our string is ${string.toUpperCase().trim().split(" ").reversed().joinToString(" ")}")

    println("simple expression is ${3 > 4 || 4 > 3 && 4 <= 4}")

    println("hard expression is ${!(9 != 9) && true || 9 > (9+3) && (!true || 3 < 9)}")

    val s = "racecar"
    println("the string s is palindrome because ${s} == ${s.reversed()}")*/

    /*    println("please enter your age: ")
    val userInput = readLine()?.toInt()
    if (userInput != null) {
        if (userInput <= 18) {
            println("you're not adult yet")
        } else if (userInput in 19..65) {
            println("you're an adult")
        } else {
            println("you're old")
        }
    }*/

    /*    val array = arrayOf("hello", "giang", "tran")
    var i = 0
    while (i < array.size) {
        println(array[i])
        i++
    }*/

    /*    println("please enter a number: ")
    var num = readLine()?.toInt()
    println("let's count from ${num} down to 0")
    if (num != null) {
        while (num >= 0) {
            println(num)
            num--
        }
    }*/

    /*    println("please enter number 1: ")
    var num1 = readLine()?.toInt()
    println("please enter number 2: ")
    var num2 = readLine()?.toInt()
    var result = 1
    var i = 0
    if (num1 != null && num2 != null) {
        while (i < num2) {
            result *= num1
            i++
        }
    }
    println("${num1} to the power of ${num2} is ${result}")*/

    /*    val array = arrayOf(4,5,8,2,6,7,9,12,14,24)
    var max = array[0]
    for (i in array) {
        if (i > max)
            max = i
    }
    println(max)
    var sum = 0
    for (i in array) {
        sum += i
    }
    println("the sum of the array is ${sum}")*/

    /*    println("please enter 5 numbers: ")
    var result = 0.0
    for (i in 1..5) {
        val x = readLine()?.toInt()
        result += x!! / 5.0
    }
    println("the average of 5 numbers is $result")*/

    /*    val array = arrayOf(1,2,3)
    val list = mutableListOf(1,2,3)

    array[0] = 3

    list[0] = 3
    list.add(4)
    list.remove(2)
    list.removeAt(1)
    println(list)

    val list1 = mutableListOf<Int>()
    for (i in 1..10) {
        val x = readLine()?.toInt()
        list.add(x!!)
    }
    println(list)*/

    /*    val list = mutableListOf<Int>()
    println("please enter 5 numbers: ")
    for (i in 1..5) {
        val x = readLine()?.toInt()
        list.add(x!!)
    }
    for (i in list.size - 1 downTo 0) {
        println(list[i])
    }*/

    /*    val age = readLine()?.toInt()
    when (age) {
        in 0..5 -> println("young kid")
        in 6..17 -> println("teenager")
        18 -> println("you're 18")
        19, 20 -> println("young adult")
        in 21..65 -> println("adult")
        else -> println("old")
    }*/

    /*    println("where are you from?")
    val input = readLine().toString()
    when (input) {
        "India" -> println("Namaste")
        "Vietnam" -> println("Xin chao")
        "Germany" -> println("Hallo")
        else -> println("Hello")
    }*/

    /*    val list = mutableListOf(0, 1) // put 2 starting number 0 and 1
    println("Please enter a number n > 1: ")
    val n = readLine()?.toInt()
    for (i in 2..n!!-1) {
        list.add(list[i-2] + list[i-1])
    }
    println(list)*/

/*    val pow = printPow(3, 5)
    println("3 to the power of 5 is $pow")
    sum(1, 5)
    println( multiply(2, 3))
    val list = listOf(1,2,3,4,5)
    printFirstItem(list)*/

/*    val list1 = listOf(3,2,5,1,5,6,7)
    println("the list looks like the following: $list1")
    println("search for this number: ")
    val x = readLine()?.toInt()
    if (x != null)
        println("the index of $x is ${searchForIndex(x, list1)}")

    val array = intArrayOf(10, 12, 13)
    val max = getMax(1,2,3,6,9,2,14,256, *array)
    println("the maximum is $max")*/

/*    searchFor("how to become a good developer")
    searchFor("how to", " Bing")
    searchFor(search = "how to be good at Kotlin", searchEngine = "Google")*/

/*    val max = alternativeSum(3,4,5,2,1,2,3)
    println("the alternative sum of the list is $max")*/

/*    println("enter a number")
    val input = readLine()?.toInt()
    if (input != null) {
        if (input.isPrime())
            println("$input is a prime number")
        else
            println("$input is not a prime number")
    }*/

/*    val list = listOf(1,2,3,4,5,6)
    println("the product of $list is ${list.productOfList()}")*/

/*    val myRect = Rectangle(4.0, 7.0)
    println("rectangle area is ${myRect.area()}")
    println("perimeter is ${myRect.perimeter()}")
    println("is rectangle a square? ${myRect.isSquare()}")

    val myCircle1 = Circle(5.0)
    val myCircle2 = Circle(7.0)*/

    //val myTriangle = Triangle(3.0, 3.0, 4.0)

/*    val myCircle1 = Circle(5.0)
    myCircle1.changeName("Round circle")
    println(myCircle1.name)
    println()

    val myTriangle = Triangle(2.0, 4.0, 4.0)
    myTriangle.changeName("My triangle")
    println(myTriangle.name)
    println()

    val myRectangle = Rectangle(4.0, 5.0)
    myRectangle.changeName("my rectangle")
    println(myRectangle.name)*/

/*    val rect = Rectangle(45.0)
    val circle = Circle(3.0)
    val triangle = Triangle(7.0, 7.0, 7.0)

    val maxAreaRectCircle = maxArea(rect, circle)
    val max = maxArea(rect, circle, triangle)*/

    val circle = Circle.randomCircle()
    println()
    val rectangle = Rectangle.randomRectangle()

/*    val a = 3.0
    val b = 4.0
    val height = 2.0
    val parallelogram = object : Shape("parallelogram", a, b, height) {
        init {
            println("$name created with a = $a, b = $b and height = $height")
            println("$name area is ${area()}")
            println("$name perimeter is ${perimeter()}")
        }

        override fun area(): Double {
            return a*height
        }

        override fun perimeter(): Double {
            return 2*a + 2*b
        }
        fun isRectangle() : Boolean = height == b
    }
    println("is the parallelogram a rectangle? ${parallelogram.isRectangle()}")*/

/*    println("please enter a number")
    val input = try {
        readLine()?.toInt()
    } catch (e: NumberFormatException) {
        0
    } finally {
        println("this is from the finally block")
    }
    println("you entered: $input")

    val division = try {
        divide(5.0, 0.0)
    } catch (e: DivisionByZeroException) {
        0.0
    }
    println("${division}")*/


}

class DivisionByZeroException : Exception("you cannot divide by zero, choose different number")

fun divide(a: Double, b: Double) : Double {
    if (b == 0.0)
        throw DivisionByZeroException()
    return a/b
}

// overloading
fun maxArea(shape1: Shape, shape2: Shape) : Double {
    val areaShape1 = shape1.area()
    val areaShape2 = shape2.area()
    return if (areaShape1 > areaShape2) areaShape1 else areaShape2
}
fun maxArea(shape1: Shape, shape2: Shape, shape3: Shape) : Double {
    val maxAreaShape1Shape2 = maxArea(shape1, shape2)
    val areShape3 = shape3.area()
    return if (maxAreaShape1Shape2 > areShape3) maxAreaShape1Shape2 else areShape3
}

fun List<Int>.productOfList() : Int {
    var product = 1
    for (i in this) {
        product *= i
    }
    return product
}

fun Int.isPrime() : Boolean {
    for (i in 2 until this-1) {
        if (this % i == 0) {
            return false
        }
    }
    return true
}

fun printFirstItem(list: List<Int>) = println(list[0])

fun printPow(x: Int, y: Int) : Int {
    var res = 1
    for (i in 1..y) {
        res *= x
    }

    return res
}

fun sum(x: Int, y: Int) {
    var sum = 0
    for (i in 1..y) {
        sum += i
    }
    println("the sum of values from $x to $y is $sum")
}

fun multiply(a: Int, b: Int) = a * b

fun searchForIndex(x: Int, list: List<Int>) : Int {
    for (i in list.indices) {
        if (x == list[i])
            return i
    }
    return -1
}

fun getMax(vararg numbers: Int) : Int {
    var max = numbers[0]
    for (number in numbers) {
        if (number > max)
            max = number
    }
    return max
}

fun searchFor(search: String, searchEngine: String = "Google") {
    println("Searching for '$search' on $searchEngine")
}

fun alternativeSum(vararg numbers: Int) : Int {
    var sum = 0
    for (i in 0 until numbers.size) {
        if (i % 2 == 0)
            sum += numbers[i]
        else
            sum -= numbers[i]
    }
    return sum
}