package array

fun lemonadeChange(bills: IntArray): Boolean {
    var five = 0
    var ten = 0

    for (bill in bills) {
        if (bill == 5) {
            five++
        } else if (bill == 10) {
            if (five == 0) return false
            five--
            ten++
        } else {
            if (five > 0 && ten > 0) {
                five--
                ten--
            } else if (five >= 3) {
                five -= 3
            } else {
                return false
            }
        }
    }
    return true
}
fun main() {
    val bills = intArrayOf(5,5,10,10,20)
    println(lemonadeChange(bills))
}

/*
If a customer brings a ＄5 bill, then we take it.

If a customer brings a ＄10 bill, we must return a five dollar bill. If we don't have a five dollar bill,
the answer is False, since we can't make correct change.

If a customer brings a ＄20 bill, we must return ＄15.

If we have a ＄10 and a ＄5, then we always prefer giving change in that, because it is strictly worse
for making change than three ＄5 bills.

Otherwise, if we have three ＄5 bills, then we'll give that.

Otherwise, we won't be able to give ＄15 in change, and the answer is False.
 */