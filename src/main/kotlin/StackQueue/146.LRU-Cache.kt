package StackQueue

class LRUCache(capacity: Int) {
    private val map = LinkedHashMap<Int, Int>(capacity, 0.75f, true)
    private val max = capacity

    fun get(key: Int): Int {
        return map.getOrDefault(key, -1)
    }

    fun put(key: Int, value: Int) {
        map[key] = value
        if (map.size > max) {
            val leastUsedKey = map.keys.iterator().next()
            map.remove(leastUsedKey)
        }
    }
}