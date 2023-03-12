package aquarium

fun main() {
    delegate()
}

fun delegate() {
    val dolphine = Dolphine()
    println("Fish has color ${dolphine.color}")
    dolphine.eat()
}
 interface FishAction1 {
     fun eat()
 }

interface FishColor {
    val color: String
}

class Dolphine1: FishAction1, FishColor {
    override fun eat() {
        println("eat fish")
    }

    override val color: String
        get() = "gold"
}

class GoldColor: FishColor {
    override val color: String
        get() = "gold"
}