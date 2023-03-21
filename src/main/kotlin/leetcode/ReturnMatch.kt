package leetcode

fun match(cheater: String, student: String): String {
    /*
    Traverse the cheater string, and for each letter, check if it’s equal to the current letter in student.

    If the letters are equal, move to the next letter in both the strings.

    When the last letter of student is matched with a letter of cheater, mark that letter position of cheater as a possible window.

    Now, go backward from the end of student and match the letters with cheater from the marked position. Do this until the student string is exhausted.

    Check if your current window is smaller than the previous one. If yes, mark it as the minimum window.

    Repeat from step 2 until you reach the end of cheater.
     */
    var window = ""
    var j = 0
    var min = cheater.length + 1
    var i = 0
    while (i < cheater.length) {
        if (cheater[i] == student[j]) {
            j++
            if (j == student.length) {
                val end = i + 1
                j--
                while (j >= 0) {
                    if (cheater[i] == student[j]) j--
                    i--
                }
                j++
                i++
                if (end - i < min) {
                    min = end - i
                    window = cheater.substring(i, end)
                }
            }
        }
        i++
    }
    return window
}
fun main() {
    val cheater = "quiqutit"
    val student = "quit"
    print("Copied Content: " + match(cheater, student))
}