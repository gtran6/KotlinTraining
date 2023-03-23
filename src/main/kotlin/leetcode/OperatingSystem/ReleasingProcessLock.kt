package leetcode.OperatingSystem

fun findUnreleasedLock(process:List<Int>):Int {
    var low = 0
    var high = process.size - 1

    //We will keep the mid even, because we will only search the even indexes.
    // This can be done by calculating the mid and then decrementing it by 1 if it is odd.
    while (low < high) {
        var mid = low + (high - low) / 2
        /*
Then, we will check whether or not the elements at the mid and mid + 1 are the same:
If mid and mid + 1 are the same, then the mid has released the lock, and the process that
hasn’t released the lock must be at an even index after mid. So, we will set lo to be mid + 2.
This way, mid will still be pointing at an even element.
If not, then the process that hasn’t released the lock is either at the mid or before it.
Therefore, we will set hi to be the mid.
         */
        if (mid % 2 == 1) mid--
        if (process[mid] == process[mid+1] )
            low = mid + 2
        else
            high = mid
    }
    return process[low]
}
fun main() {
    val process = listOf(1,1,2,2,3,3,4,4,5,8,8)
    println(findUnreleasedLock(process))
}