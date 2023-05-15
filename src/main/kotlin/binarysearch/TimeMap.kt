package binarysearch

class TimeMap {
    private val map = mutableMapOf<String, MutableList<Pair<String, Int>>>()

    fun set(key: String, value: String, timestamp: Int) {
        if (!map.containsKey(key)) {
            map[key] = mutableListOf()
        }
        map[key]!! += Pair(value, timestamp)
    }

    fun get(key: String, timestamp: Int): String {
        if (!map.containsKey(key)) return ""

        if ((map[key]?.get(0)?.second)!! > timestamp) return ""

        var left = 0
        var right = map[key]?.size

        while (left < right!!) {
            val mid = left + (right - left) / 2
            if (map[key]?.get(mid)?.second!! <= timestamp) {
                left = mid + 1
            } else {
                right = mid
            }
        }

        if (right == 0) return ""
        return map[key]?.get(right - 1)?.first ?: ""
    }
}