package leetcode.Netflix

import java.util.Stack

class FreqStack2() {

    var frequency: MutableMap<Int, Int> = HashMap()
    var group: MutableMap<Int, Stack<Int>> = HashMap()
    var maxFrequency = 0
    fun push(`val`: Int) {
        val f = frequency.getOrDefault(`val`, 0) + 1
        frequency[`val`] = f

        if (f > maxFrequency) maxFrequency = f
        group.computeIfAbsent(f) {
            Stack()
        }.push(`val`)
    }

    fun pop(): Int {
        var data = 0
        if (maxFrequency > 0) {
            data = group[maxFrequency]!!.pop()
            frequency[data] = frequency[data]!! - 1

            if (group[maxFrequency]!!.size == 0) maxFrequency--
        }
        return data
    }
}

fun main() {
    val num = FreqStack2()
    num.push(1)
    num.push(5)
    num.push(7)
    num.push(5)
    num.push(7)
    num.push(4)
    num.push(0)
    num.push(0)
    num.push(0)
    num.push(0)
    for (i in 0 until 10) {
        println(num.pop())
    }
}