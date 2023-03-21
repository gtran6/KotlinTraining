package leetcode

fun maxProfit(A: IntArray?) : Int {
    if (A!!.isEmpty()) return 0
    //Initialize a currentMax and a globalMax and assign them the first value of the array.
    var currentMax = A?.get(0)
    var globalMax = A?.get(0)

    //Traverse the array starting with the second element.
    for (i in 1 until A!!.size) {
        //For each element, check whether currentMax is less than zero:
        if (currentMax!! < 0) {
            // checks if currMax is negative. If it is, then the next element A[i] becomes the new currMax.
            currentMax = A[i]
        } else {
            //Otherwise, currMax is updated to the sum of itself and the next element A[i].
            currentMax = currentMax!! + A[i]
        }
        // for each element checks if the current currMax is greater than the current globalMax.
        // If it is, then the globalMax is updated to currMax.
        if (globalMax!! < currentMax) {
            globalMax = currentMax
        }
    }
    return globalMax!!
}
fun main() {
    // Driver code
    val stocks = intArrayOf(-4, 2, -5, 1, 2, 3, 6, -5, 1)
    println("Maximum Profit: " + maxProfit(stocks) + "%")
}