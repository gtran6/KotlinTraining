package Backtracking

fun restoreIpAddresses(s: String): List<String> {
    val result = mutableListOf<String>()
    val segments = mutableListOf<String>()

    fun backtrack(start: Int, segmentsCount: Int) {
        // Base case: found 4 segments that form a valid IP address
        if (segmentsCount == 4 && start == s.length) {
            result.add(segments.joinToString("."))
            // Base case: exceeded 4 segments or reached the end of the string
        } else if (segmentsCount == 4 || start == s.length) {
            return
        }

        // Try all possible segment lengths (1-3)
        for (i in 1..3) {
            // Check if the current segment is within the string boundaries
            if (start+i-1 >= s.length) break

            // Check if the current segment has a leading zero
            if (i > 1 && s[start] == '0') break

            // Check if the current segment is within the valid range (0-255)
            val segment = s.substring(start, start+i)
            if (segment.toInt() > 255) break

            // Add the current segment to the list and backtrack with the next segment
            segments.add(segment)
            backtrack(start+i, segmentsCount+1)
            segments.removeAt(segments.lastIndex)
        }
    }
    backtrack(0, 0)
    return result
}
fun main() {
    val s = "101023"
    println(restoreIpAddresses(s))
}