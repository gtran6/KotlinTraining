package Basics

fun main() {
    var trainee:Trainee = Trainee(5, "kotlin inheritance", "1")
    trainee.inheritanceDemo()
}

open class KotlinTrainee(var name:String, var id:Int) {
    open fun inheritanceDemo() {
        println("name: $name, id: $id")
    }
}

class Trainee(duration:Int, topic:String, var module:String):KotlinTrainee(topic, duration) {
    override fun inheritanceDemo() {
        super.inheritanceDemo()
        println("module is: $module of topic: $name with duration: $id")
    }
}