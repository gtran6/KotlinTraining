package stack

import java.util.Stack

// stack
fun carFleet1(target: Int, position: IntArray, speed: IntArray): Int {
    val n = position.size
    if (n == 0) return 0

    // Create pairs of position and time taken to reach target
    val cars = Array(n) { i -> Pair(position[i], (target - position[i]).toDouble() / speed[i]) }

    // Sort cars by position
    cars.sortByDescending { it.first }

    var numFleets = 1
    var prevTime = cars[0].second

    // Iterate over cars from the back and merge fleets
    for (i in 1 until n) {
        val currTime = cars[i].second
        if (currTime > prevTime) {
            numFleets++
            prevTime = currTime
        }
    }

    return numFleets
}

fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
    val n = position.size
    if (n == 0) {
        return 0
    }

    // Calculate time taken for each car to reach target
    val times = DoubleArray(n)
    for (i in 0 until n) {
        times[i] = (target - position[i]) / speed[i].toDouble()
    }

    // Sort cars by their positions in descending order
    val indices = position.indices.sortedByDescending { position[it] }

    var count = 1
    var prevIndex = indices[0]
    for (i in 1 until n) {
        val index = indices[i]
        if (times[index] <= times[prevIndex]) {
            // Car fleet merges with the previous car fleet
            times[index] = times[prevIndex]
        } else {
            // Car fleet doesn't catch up to the previous car fleet
            count++
            prevIndex = index
        }
    }

    return count
}
fun main() {
    val target = 12
    val position = intArrayOf(10,8,0,5,3)
    val speed = intArrayOf(2,4,1,1,3)
    println(carFleet1(target, position, speed))
}