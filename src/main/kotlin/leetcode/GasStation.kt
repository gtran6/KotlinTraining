package leetcode

    /*
    We cannot perform the road trip if sum(gas) < sum(cost).
    In this situation, the answer will be -1. We can compute the total amount
    of gas in the tank, total_tank = sum(gas) - sum(cost), during the round trip.
    The round trip is only possible if total_tank >= 0, otherwise we return -1.

    We cannot start the trip at a station i if gas[i] - cost[i] < 0, because then
    there is not enough gas in the tank to travel to the i + 1 station. Let’s say
    we have a curr_tank variable that keeps track of the current amount of gas in
    the tank. If at a station curr_tank is less than 0, this means that we cannot
    reach this station. Then, we need to mark this station as a new starting point
    and reset curr_tank to 0 since, at this station, we start with no gas in the tank.
     */
fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    var total = 0
    var curr = 0
    var start = 0
     for (i in 0 until gas.size) {
         total += gas[i] - cost[i]
         curr += gas[i] - cost[i]
         if (curr < 0) {
             start = i+1 // starts at i+1 because at i, there's not enough gas to start
             curr = 0
         }
     }
    return if (total >= 0) start
    else -1
}
fun main() {
    val gas = intArrayOf(1,2,3,4,5)
    val cost = intArrayOf(3,4,5,1,2)
    println(canCompleteCircuit(gas, cost))
}