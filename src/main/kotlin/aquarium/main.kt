package aquarium

import Collections.spices

fun main() {
    //buildAquarium()
    //simpleSpice()
    makeFish()
}

fun simpleSpice() {
    val spice = Spice("curry", "mild", 3)
    println("name is ${spice.name} and heat is ${spice.heat}")
}

fun buildAquarium() {
    val myAquarium = Aquarium()
    println(myAquarium.width + myAquarium.length + myAquarium.height)
    myAquarium.height = 80
    println("height: ${myAquarium.height}")

    println("volume: ${myAquarium.volume}")

    val smallAquarium = Aquarium(20, 15, 30)
    println(smallAquarium.volume)
    val myAquarium2 = Aquarium(numOfFish = 9)
    println(myAquarium2.water)
}

fun feedFish(fish: FishAction) {
    fish.eat()
}

fun makeFish() {
    val shark = Shark()
    val dolphine = Dolphine()

    println("Shark: ${shark.color} and Dolphine: ${dolphine.color}")
    shark.eat()
    dolphine.eat()
}
