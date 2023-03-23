package leetcode.Scrabble

fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
    var count = 1
    val wordSet = wordList.toSet()
    if (!wordSet.contains(endWord)) return 0
    val queue = ArrayDeque<String>()
    queue.add(beginWord)
    val visited = mutableSetOf(beginWord)

    while (queue.isNotEmpty()) {
        for (i in 0 until queue.size) {
            val word = queue.removeFirst()
            for (j in word.indices) {
                for (c in 'a'..'z') {
                    val newWord = word.substring(0,j) + c + word.substring(j+1)
                    if (newWord == endWord) return count+1
                    if (newWord in wordSet && !visited.contains(newWord)) {
                        queue.add(newWord)
                        visited.add(newWord)
                    }
                }
            }
        }
        count++
    }
    return 0
}
fun main() {
    val beginWord = "hit"
    val endWord = "cog"
    val wordList = listOf("hot","dot","dog","lot","log","cog")
    println(ladderLength(beginWord, endWord, wordList))
}