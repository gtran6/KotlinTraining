package aquarium

// abstract classes can have constructors and interface cannot
// both can contain implementations of methods
abstract class AquariumFish {
    abstract val color: String
}

class Shark: AquariumFish(), FishAction {
    override val color: String
        get() = "white"

    override fun eat() {
        println("hunt and eat fish")
    }
}

class Dolphine: AquariumFish(), FishAction {
    override val color: String
        get() = "gold"

    override fun eat() {
        println("don't eat other fish")
    }
}

interface FishAction {
    fun eat()
}