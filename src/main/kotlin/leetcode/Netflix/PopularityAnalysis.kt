package leetcode.Netflix

fun identifyTitles(scores: IntArray): Boolean {
    var increasing = true
    var decreasing = true

    for (i in 0 until scores.size - 1) {
        if (scores[i] < scores[i+1]) decreasing = false
        if (scores[i] > scores[i+1]) increasing = false
    }

    return increasing || decreasing
}
fun main() {
    val movieRating = arrayOf(intArrayOf(1,2,2,3), intArrayOf(4,5,6,7,4), intArrayOf(8,8,7,6,5,4,4,1))
    for (i in movieRating) {
        println(identifyTitles(i))
    }
}