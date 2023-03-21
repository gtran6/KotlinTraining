package leetcode.Netflix

import kotlin.collections.ArrayList
import kotlin.collections.HashMap
/*
Since the goal is to club elements with same quality and quantity of strings,
hashmap needs to be created to store same category of strings.
Create map with string as key and list as value then run loop for strings in
list then add element to the map if not present or if present then append
the string to the value list
 */
fun groupTitles(strs: Array<String>): List<List<String>> {
    if (strs.isEmpty()) return ArrayList()
    // keys represent the character counts of each string in strs
    // values represent the anagram of each other in strs
    val map: MutableMap<String, MutableList<String>> = HashMap()
    for (s in strs) {
        val key = String(s.toCharArray().sortedArray())
        if (!map.containsKey(key)) map[key] = ArrayList()
        map[key]!!.add(s)
    }
    return map.values.toList()
//    return strs.groupBy {
//        it.toCharArray().sort()
//    }.map {
//        it.value
//    }
}
fun main() {
    val titles = arrayOf("duel", "dule", "speed", "spede", "deul", "cars")
    val gt: List<List<String?>> = groupTitles(titles)
    println(gt)
}