package string

fun romanToInt(s: String): Int {
    val map = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )
    var number = 0
    var last = 1000
    s.forEach {
        val value = map[it] ?: 0
        if (value > last) number -= last * 2
        number += value
        last = value
    }
    return number
}
fun main() {
    val s = "MCMLIV"
    println(romanToInt(s))
}
/*
We've got a map containing the roman numerals, then we iterate through the string.
We check the value for each character in the map. If it's null because it's not in
there we pretend it's zero.

If this value is greater than the last value, this means we have one of the
conditions where for example an I is put in front of an X or a V, so we have
to do some extra calculating. We already added it to the sum last pass through,
so now we need to subtract it twice. Then we add the present value and save this
value to serve as the last value for the next pass through.

*/