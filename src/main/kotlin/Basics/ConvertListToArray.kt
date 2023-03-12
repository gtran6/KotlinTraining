package Basics

fun main() {
    val list1 : List<Int> = listOf(9, 3, 2, 5, 7)
    val list2 : List<Int> = listOf(6, 8, 3, 5, 0, 2)
    val list3 = ArrayList<Int>()
    list3.addAll(list1)
    list3.addAll(list2)
    println(list3)

    val array : Array<Int> = list1.toTypedArray()

    array.forEach {
        println(it)
    }
}