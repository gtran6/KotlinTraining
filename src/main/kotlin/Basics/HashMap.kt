package Basics

fun main() {
    val trainingDetail = hashMapOf<Int, String>()

    trainingDetail.put(145, "Cat")
    trainingDetail.put(873, "Dog")
    trainingDetail.put(862, "Fish")

    for (i in trainingDetail) {
        println(i.key.toString() + " " + i.value)
    }
}