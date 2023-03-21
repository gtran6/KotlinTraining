package leetcode

// fins the minimum number of hops required to traverse an array,
// where each integer presents the maximum number of steps that can
// be taken from its index
fun minimumHops(values: IntArray) : Int {
    var hops = 1 // assume that we need at least one hop to reach the end
    // initialize these var to the first element since we can reach only as
    // far as the first element in the first hop.
    var max = values[0] // the maximum step that can be reached from the current index
    var curr = values[0]

    //keeping track of the maximum index that can be reached so far (maxReach)
    // and the maximum index that can be reached in the current hop (currReach).
    for (i in 1 until values.size) {

        // if current reach is greater than i, it means that
        // we are ready for another hop
        if (curr < i) {
            hops++
            curr = max
        }
        // (i+values[i]) represents the maximum index we can reach from the current index
        max = maxOf(max, i+values[i])
    }
    return hops

}
fun main() {
    val switch_array = intArrayOf(2, 0, 2, 4, 6, 0, 0, 3)
    println(minimumHops(switch_array))
}