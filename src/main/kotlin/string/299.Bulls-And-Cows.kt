package string

fun getHint(secret: String, guess: String): String {
    val map = HashMap<Char, Int>()
    var bulls = 0
    var cows = 0

    for (i in secret.indices) {
        if (secret[i] == guess[i]) {
            bulls++
        } else {
            if (map.getOrDefault(secret[i], 0) < 0) cows++
            if (map.getOrDefault(guess[i], 0) > 0) cows++
            // map = { "1" -> 0, "8" -> 0, "0" -> 0, "7" -> 0 }
            map[secret[i]] = map.getOrDefault(secret[i], 0) + 1
            map[guess[i]] = map.getOrDefault(guess[i], 0) - 1
        }
    }
    return "${bulls}A${cows}B"
}
fun main() {
    val secret = "1807"
    val guess = "7810"
    println(getHint(secret, guess))
}