package leetcode.Netflix

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun groupAnagrams(strs: List<String>): List<List<String>> {
//    if (strs.isEmpty()) return emptyList()
//    val map: MutableMap<String, MutableList<String>> = HashMap()
//    val count = IntArray(26)
//    for (s in strs) {
//        Arrays.fill(count, 0)
//        for (c in s.toCharArray()) {
//            count[c - 'a']++
//        }
//        val string = StringBuilder("")
//        for (i in 0..25) {
//            string.append('#')
//            string.append(count[i])
//        }
//        val key = string.toString()
//        if (!map.containsKey(key)) map[key] = ArrayList()
//        map[key]!!.add(s)
//    }
//    return map.values.toList()
    return strs.groupBy {
        it.toCharArray().sorted()
    }.map { it.value }
}
fun main() {
    val strs = listOf("word", "sword", "drow", "rowd", "iced", "dice")
    println(groupAnagrams(strs))
}
/*
time : O(n * klogk)
space : O(n)
 */

/*
The 'groupBy' function of strs creates a map where the keys are the sorted character arrays
of the strings in strs, and the values are lists of strings with the same sorted character array.
{
    [a, e, t] = [eat, tea, ate],
    [a, n, t] = [tan, nat],
    [a, b, t] = [bat]
}

The 'map' function is used to extract the values of the map, which are the lists of anagrams
{
    [eat, tea, ate],
    [tan, nat],
    [bat]
}
 */