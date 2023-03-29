package FastAndSlowPointers
/*
A happy number is a number defined by the following process:
Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals (where it will stay), or it loops endlessly in a cycle which does not include
Those numbers for which this process ends in are happy.
Return TRUE if is a happy number, and FALSE if not.
 */
fun isHappyNumber(n: Int) : Boolean {
    var slow = n
    var fast = n

    while (true) {
        //Incrementing the slow pointer by 1 iteration
        slow = sumDigits(slow)
        //Incrementing the fast pointer by 2 iterations
        fast = sumDigits(sumDigits(fast))
        if (fast == 1) return true //If 1 is found then it returns True, otherwise False
        if (slow == fast) return false // line checks if slow is equal to fast. If it is, an infinite loop has been detected and the function returns false,
    }
}

fun sumDigits(n: Int): Int {
    var sum = 0
    var num = n
    while (num > 0) {
        val digit = num % 10
        sum += digit*digit
        num /= 10
    }
    return sum
}

fun main() {
    val n = 19
    println(isHappyNumber(n))
}
