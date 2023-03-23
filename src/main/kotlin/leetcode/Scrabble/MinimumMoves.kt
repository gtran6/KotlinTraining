package leetcode.Scrabble

fun minimumMoves(beginWord: String, endWord: String, wordList: List<String>): Int {
    var count = 0
    // Create a set of words from the word list
    val wordSet = wordList.toSet()
    // Check if endWord is in the word list
    if (!wordSet.contains(endWord)) return 0
    // Create a queue for BFS and add the beginWord
    val queue = ArrayDeque<String>()
    queue.add(beginWord)
    // Create a set to keep track of visited words
    val visited = mutableSetOf(beginWord)

    while (queue.isNotEmpty()) {
        count++
        for (i in 0 until queue.size) {
            val word = queue.removeFirst()
            for (j in word.indices) {
                for (c in 'a'..'z') {
                    val newWord = word.substring(0, j) + c + word.substring(j + 1)
                    if (newWord == endWord) return count
                    if (newWord in wordSet && !visited.contains(newWord)) {
                        queue.add(newWord)
                        visited.add(newWord)
                    }
                }
            }
        }
    }
    return 0
}
fun main() {
    val beginWord = "hit"
    val endWord = "cog"
    val wordList = listOf("hot", "dot", "dog", "lot", "log", "cog")
    print(
        "The shortest sequence is of length: " + minimumMoves(
            beginWord,
            endWord,
            wordList
        )
    )
}