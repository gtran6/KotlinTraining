package Collections

// Map is a set of key-value pairs, designed to make it easy to look up a value given a particular key.
// Keys are unique, and each key maps to exactly one value, but the values can have duplicates.
// Values in a map can be strings, numbers, or objects—even another collection like a list or a set.
// A map is useful when you have pairs of data, and you can identify each pair based on its key. The key "maps to" the corresponding value.
fun main() {
    val peopleAges = mutableMapOf<String, Int>("Fred" to 30, "Ann" to 23)
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51
    peopleAges["Joe"] = 54
    //println(peopleAges)

    // "forEach" is similar to the for loop, but a little more compact.
    // Instead of you specifying a variable for the current item, the forEach uses the special identifier it.
    peopleAges.forEach {
        //println(it.key + " is " + it.value)
        println("${it.key} is ${it.value}")
    }

    println(peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", "))
 }