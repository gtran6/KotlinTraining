package leetcode.Netflix

import java.util.Stack

var frequency: MutableMap<String, Int> = HashMap()
var group: MutableMap<Int, Stack<String>> = HashMap()
var maxFrequency: Int =0

internal class FreqStack {
    fun push(showName: String) {

        val f = frequency.getOrDefault(showName, 0) + 1
        frequency[showName] = f

        if (f > maxFrequency) maxFrequency = f
        group.computeIfAbsent(f) { Stack() }.push(showName)
    }

    fun pop(): String {
        var show = ""
        if (maxFrequency > 0) {
            show = group[maxFrequency]!!.pop()
            frequency[show] = frequency[show]!! - 1

            if (group[maxFrequency]!!.size == 0) maxFrequency--
        }
        return show
    }
}

fun main() {
    val movie = FreqStack()
    movie.push("Queen's Gambit")
    movie.push("Teen Wolf")
    movie.push("Queen's Gambit")
    movie.push("Teen Wolf")
    movie.push("Bridgerton")
    movie.push("Queen's Gambit")
    for (i in 0..6) {
        println("...User navigates to the browser...")
        println("Continue Watching :" + movie.pop())
        println()
    }
}