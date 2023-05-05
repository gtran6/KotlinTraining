package Topological

import java.util.*

fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
    val res = mutableListOf<Int>()
    if (numCourses <= 0) return res.toIntArray()

    val adjList = Array(numCourses) { mutableListOf<Int>() }
    val inDegree = IntArray(numCourses)

    for (p in prerequisites) {
        val course = p[0]
        val preReqCourse = p[1]
        adjList[preReqCourse].add(course)
        inDegree[course]++
    }

    val queue: Queue<Int> = LinkedList()
    for (i in 0 until numCourses) {
        if (inDegree[i] == 0) {
            queue.add(i)
        }
    }

    while (!queue.isEmpty()) {
        val course = queue.poll()
        res.add(course)

        for (neighbor in adjList[course]) {
            inDegree[neighbor]--
            if (inDegree[neighbor] == 0) {
                queue.offer(neighbor)
            }
        }
    }
    return if (res.size != numCourses) emptyArray<Int>().toIntArray() else res.toIntArray()
}
fun main() {
    val numCourses = 4
    val prerequisites = arrayOf(intArrayOf(1,0), intArrayOf(2,0), intArrayOf(3,1), intArrayOf(3,2))
    println(findOrder(numCourses, prerequisites).contentToString())
}