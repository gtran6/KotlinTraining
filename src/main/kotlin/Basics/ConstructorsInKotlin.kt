package Basics

fun main() {
    val kotlinDemo = KotlinDemo(4, "kotlin training")
    println(kotlinDemo.time)

    val kotlinDemo1 = KotlinDemo1(6, "kotlin second demo")
/*    kotlinDemo1.topic = "Giang Tran"
    println(kotlinDemo1.topic)*/

    val kotlinDemo2 = KotlinDemo2(5, "kotlin third demo")
    val kotlinDemo2Secondary = KotlinDemo2(10)
    println(kotlinDemo2.course)
    println(kotlinDemo2Secondary.course)
}

// 1. primary constructor
class KotlinDemo(duration:Int, course:String) {
    var time:Int = duration
    var topic:String = course
}

//2. primary constructor with initializer block
class KotlinDemo1(var duration:Int, var course:String) {
/*    lateinit var time:Array<Int>
    lateinit var topic:String*/

    /*init {
        time = duration
        topic = course
    }*/
}

// 3. secondary constructor
class KotlinDemo2(var duration:Int, var course:String) {
/*    var duration:Int = 0
    var course:String = "kotlin training"*/

    constructor(durationInput: Int) : this(durationInput, "kotlin third demo secondary") {

/*        this.duration = duration
        this.course = course*/
    }
}