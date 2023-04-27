package array

fun countLatticePoints(circles: Array<IntArray>): Int {
    var count = 0
    var minX = Int.MAX_VALUE
    var maxX = Int.MIN_VALUE
    var minY = Int.MAX_VALUE
    var maxY = Int.MIN_VALUE

    for (circle in circles) {
        val x = circle[0]
        val y = circle[1]
        val r = circle[2]

        minX = minOf(minX, x-r)
        maxX = maxOf(maxX, x+r)
        minY = minOf(minY, y-r)
        maxY = maxOf(maxY, y+r)
    }

    for (x in minX..maxX) {
        for (y in minY..maxY) {
            var inside = false

            for (circle in circles) {
                val cx = circle[0]
                val cy = circle[1]
                val r = circle[2]

                if ((x-cx) * (x-cx) + (y-cy) * (y-cy) <= r*r) {
                    inside = true
                    break
                }
            }
            if (inside) {
                count++
            }
        }
    }
    return count
}
fun main() {
    val circles = arrayOf(intArrayOf(2,2,2), intArrayOf(3,4,1))
    println(countLatticePoints(circles))
}