package Topological

import DataStructures.LinkedList
import java.util.*

fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val adjList = Array(numCourses) { mutableListOf<Int>() }
    val inDegree = IntArray(numCourses)

    for (preReq in prerequisites) {
        val course = preReq[0]
        val preReqCourse = preReq[1]
        adjList[preReqCourse].add(course)
        inDegree[course]++
    }

    val queue: Queue<Int> = java.util.LinkedList()
    for (course in 0 until numCourses) {
        if (inDegree[course] == 0) {
            queue.add(course)
        }
    }

    var count = 0
    while (queue.isNotEmpty()) {
        val course = queue.poll()
        count++

        for (neighbor in adjList[course]) {
            inDegree[neighbor]--
            if (inDegree[neighbor] == 0) {
                queue.offer(neighbor)
            }
        }
    }
    return count == numCourses
}
fun main() {
    val numCourses = 4
    val prerequisites = arrayOf(intArrayOf(1,0), intArrayOf(2,0), intArrayOf(3,1), intArrayOf(3,2))
    println(canFinish(numCourses, prerequisites))
}