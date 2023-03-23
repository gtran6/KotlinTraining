package leetcode.Scrabble

fun wordLadder(
    startingWord: String, endingWord: String,
    wordList: Array<String>
): Int {
    var count = 0
    // Create a set of words from the word list
    val wordSet = wordList.toSet()
    // Check if endWord is in the word list
    if (!wordSet.contains(endingWord)) return 0
    // Create a queue for BFS and add the beginWord
    val queue = ArrayDeque<String>()
    queue.add(startingWord)
    // Create a set to keep track of visited words
    val visited = mutableSetOf(startingWord)

    while (queue.isNotEmpty()) {
        count++
        for (i in 0 until queue.size) {
            val word = queue.removeFirst()
            for (j in word.indices) {
                for (c in 'a'..'z') {
                    val newWord = word.substring(0, j) + c + word.substring(j + 1)
                    if (newWord == endingWord) return count
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
    val startingWord = "hit"
    val endingWord = "cog"
    val wordList = arrayOf("hot","dot","dog","lot","log","cog")
    println(wordLadder(startingWord, endingWord, wordList))
}