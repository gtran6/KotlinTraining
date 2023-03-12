package Collections

fun main() {
    val peopleAges = mutableMapOf<String, Int>("Fred" to 30, "Ann" to 23)
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51
    peopleAges["Joe"] = 54

    val filteredNames = peopleAges.filter { it.key.length < 5 }
    //println(filteredNames)

    val decorations = listOf("rock", "pagoda", "plastic giant")
    //println(decorations.filter { true })
    //println(decorations.filter { it[0] == 'p' }) // "it" refers to each element
    //println(decorations.filter { it[1] == 'a' })
    //eager()
    spices()
}

fun eager() {
    val decorations = listOf("rock", "pagoda", "plastic giant", "alligator", "flowerpot")
    val eager = decorations.filter { it[0] == 'p' }
    //println(eager)

    // apply filter lazily
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    //println(filtered)
    //println(filtered.toList())

    // apply map lazily
    val lazyMap = decorations.asSequence().map {
        println("map: ${it}")
    }
    println(lazyMap)
    println("first: ${lazyMap.first()}")
    println("all: ${lazyMap.toList()}")
}

fun spices() {
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )
    //println(spices.filter { it[0] == 'c' && it[(it.length-1)] == 'e' })

    val threeElements = spices.take(3) // Take the first three elements of the list
    val res = threeElements.filter { it.startsWith('c') }
    println(res)
}