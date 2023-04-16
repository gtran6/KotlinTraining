package leetcode

/* Overview:
 Write a program, in Kotlin, that will display an ASCII chart given the following data
 data = {(1,2), (2, 3), (3, 1), (4, 6), (5, 8)}.
 You should be able to print the surrounding components of the chart and then place an * where
 each data point is specified in the data set. You do not need to print the X and Y legends
 but that would be helpful. You are given the max x and max y but if you can calculate that
 it would be helpful.

  Online auction graph display
  x axis is time
  y axis is price
  Title item

  Given a two-dimension array graph the price over time

     +-----+-----+-----+-----+-----+-----+
     +-----------------------------*-----+
     +-----------------------------------+
     +-----------------------*-----------+
     +-----------------------------------+
     +-----------------------------------+
     +-----------*-----------------------+
     +-----*-----------------------------+
     +-----------------*-----------------+
     +-----+-----+-----+-----+-----+-----+


   max x = 5
   max y = 8
   data = {(1,2), (2, 3), (3, 1), (4, 6), (5, 8)}
 To execute Kotlin code, please define a top level function named main*/
fun main() {
    val data = setOf(
        Pair(1,2),
        Pair(2,3),
        Pair(3,1),
        Pair(4,6),
        Pair(5,8)
    )
    val maxX = 5
    val maxY = 8
    for (y in maxY downTo 1) {
        print("+")
        for (x in 1..maxX) {
            print(if (data.contains(Pair(x, y))) "*" else "-")
            print(if (x == maxX) "+\n" else "-----")
        }
    }
    print("+")
    for (x in 1..maxX) {
        print("-")
        print(if (x == maxX) "+\n" else "-----")
    }
/*    println("+-----+-----+-----+-----+-----+-----+")

    for (y in maxY downTo 1) {
        var line = "+"
        for (x in 1..maxX) {
            if (data.contains(Pair(x, y))) {
                line += "-----*-----"
            } else {
                line += "-----"
            }
            line += "-"
        }
        println(line)
    }

    // Print bottom border
    println("+-----+-----+-----+-----+-----+-----+")*/
}
