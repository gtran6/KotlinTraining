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
    val s = "MCMXCIV"
    println(romanToInt(s))
}
/*
We've got a map containing the roman numerals, then we iterate through the string.
We check the value for each character in the map. If it's null because it's not in
there we pretend it's zero.

If this value is greater than the last value, this means we have one of the
conditions where for example an I is put in front of an X or a V, so we have
to do some extra calculating. We already added it to the sum last passthrough,
so now we need to subtract it twice. Then we add the present value and save this
value to serve as the last value for the next passthrough.
 */

/*
Here's an example to illustrate how this code works. Let's consider the Roman numeral string "MCMLIV". We start by initializing number to 0 and last to 1000.

The first character is 'M', which has a value of 1000. last is updated to 1000, and number is updated to 1000.
The second character is 'C', which has a value of 100. Since 100 is less than 1000, we simply add 100 to number. last is updated to 100 for the next iteration.
The third character is 'M', which has a value of 1000. Since 1000 is greater than 100, we subtract twice the value of the last character (which is 100), which gives us 800. We add 1000 to 800 to get 1800, which is the updated value of number. last is updated to 1000 for the next iteration.
The fourth character is 'L', which has a value of 50. Since 50 is less than 1000, we simply add 50 to number. last is updated to 50 for the next iteration.
The fifth character is 'I', which has a value of 1. Since 1 is less than 50, we simply add 1 to number. last is updated to 1 for the next iteration.
The sixth character is 'V', which has a value of 5. Since 5 is less than 1, we simply add 5 to number. last is updated to 5 for the next iteration.
After the loop finishes, number contains the value 1954, which is the correct integer value of the Roman numeral "MCMLIV".
 */