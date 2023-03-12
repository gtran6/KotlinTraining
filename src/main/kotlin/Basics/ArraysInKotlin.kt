package Basics

fun findMaximumOrMinimum(arr:Array<Int>, flag:String):Int {
    var max = arr[0]
    var min = arr[0]

    if (flag == "Min") {
        for (num in arr) {
            if (num < min)
                min = num
        }
        return min
    } else {
        for (num in arr) {
            if (num > max)
                max = num
        }
        return max
    }
}

fun main() {
    var trainees:Array<String> = arrayOf("Giang", "Adrew", "Erfan")
    println("Participants are: ${trainees.get(0)}")

    var arr:Array<Int> = arrayOf(2432, 5609, 452, -123)
    println(findMaximumOrMinimum(arr, "Min"))
    println(findMaximumOrMinimum(arr, "Max"))
}