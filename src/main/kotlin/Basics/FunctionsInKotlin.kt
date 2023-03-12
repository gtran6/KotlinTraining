package Basics

fun highLevelFunctionDemo(duration: Int, topic: String, demoFunction:(Int, String)->String):String {
    return demoFunction(duration, topic)
}

fun training(duration:Int, topic:String) {
    println("Topic is: $topic, duration is: $duration")
}

//vararg: variable arguments
fun match(vararg num:Int):Int {
    var zero = 0

    for (count in num) {
        zero += count
    }
    return zero
}
fun main() {
    training(4, "kotlin training")

    val tmpFunc:(Int, String)->String = {time, course -> "$time hrs is allocated for $course"}

    println(highLevelFunctionDemo(4, "kotlin training", tmpFunc))

    println(match(5,7,8,10))
}