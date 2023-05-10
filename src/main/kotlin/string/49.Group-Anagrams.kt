package string

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    if (strs.isEmpty()) return ArrayList()
    val map = mutableMapOf<String, MutableList<String>>()

    for (s in strs) {

        val string = String(s.toCharArray().sortedArray())

        if (!map.contains(string)) {
            map[string] = ArrayList()
        }
        map[string]?.add(s)
    }
    return map.values.toList()
}
fun main() {
    val strs = arrayOf("eat","tea","tan","ate","nat","bat")
    println(groupAnagrams(strs))
}
