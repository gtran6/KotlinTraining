package leetcode.OperatingSystem

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun scheduleProcess(vertices: Int, edges: Array<IntArray>): List<Int> {
    val sortedOrder: MutableList<Int> = ArrayList()
    if (vertices <= 0) return sortedOrder

    // a. Initialize the graph
    val inDegree = HashMap<Int, Int>() // count of incoming edges for every vertex
    val graph = HashMap<Int, MutableList<Int>>() // adjacency list graph

    for (i in 0 until vertices) {
        inDegree[i] = 0
        graph[i] = ArrayList()
    }

    // b. Build the graph
    for (i in edges.indices) {
        val parent = edges[i][1]
        val child = edges[i][0]
        graph[parent]!!.add(child) // put the child into it's parent's list
        inDegree[child] = inDegree[child]!! + 1 // increment child's inDegree
    }

    // c. Find all sources i.e., all vertices with 0 in-degrees
    val sources: Queue<Int> = LinkedList()
    for ((key, value) in inDegree) {
        if (value == 0) sources.add(key)
    }

    // d. For each source, add it to the sortedOrder and subtract one from all of its children's in-degrees
    // if a child's in-degree becomes zero, add it to the sources queue
    while (!sources.isEmpty()) {
        val vertex = sources.poll()
        sortedOrder.add(vertex)
        val children: List<Int> = graph[vertex]!! // get the node's children to decrement their in-degrees
        for (child in children) {
            inDegree[child] = inDegree[child]!! - 1

            if (inDegree[child] == 0) sources.add(child)
        }
    }
    return if (sortedOrder.size != vertices) ArrayList() else sortedOrder
}
fun main() {
    val vertices = 4
    val edges = arrayOf(intArrayOf(1,0), intArrayOf(2,0), intArrayOf(3,1), intArrayOf(3,2))
    println(scheduleProcess(vertices, edges))
}