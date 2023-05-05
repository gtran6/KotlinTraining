package leetcode.OperatingSystem

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun identifyConcatenations(words: Array<String>): List<String> {
    val res: MutableList<String> = ArrayList()
    val wordSet = HashSet(mutableListOf(words))
    val cache = HashMap<String, Boolean>()

    for (word in words) {
        if (dfs5(word, wordSet, cache)) {
            res.add(word)
        }
    }
    return res
}

fun dfs5(word: String, wordSet: HashSet<String>, cache: HashMap<String, Boolean>): Boolean {
    if (cache.contains(word)) return cache[word]!!

    for (i in 1 until word.length) {
        val prefix = word.substring(0, i)
        val suffix = word.substring(i)

        if (wordSet.contains(prefix)) {
            if (wordSet.contains(suffix) || dfs5(suffix, wordSet, cache)) {
                cache[word] = true
                return true
            }
        }
    }
    cache[word] = false
    return false
}
fun main() {
    val words = arrayOf("n", "cat", "cats", "dog", "catsndog")
    println(identifyConcatenations(words))
}
