package aquarium

class Fish(val friendly: Boolean = true, volumeNeeded: Int) {

    val size: Int

    constructor() : this(true, 9) {
        println()
    }

    init {
        if (friendly) {
            size = volumeNeeded
        } else {
            size = volumeNeeded * 2
        }
    }
}

fun fish() {
    val fish = Fish(true, 20)
    println(fish)
}