package array

fun firstBadVersion(n: Int) : Int {
    var start = 1
    var end = n

    while (start < end) {
        var mid = start + (end - start) / 2
        if (isBadVersion(mid)) end = mid
        else start = mid + 1
    }
    return start
}
fun isBadVersion(version: Int): Boolean {
    return true
}