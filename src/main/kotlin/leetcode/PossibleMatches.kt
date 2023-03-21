package leetcode

import java.text.StringCharacterIterator

fun possibleMatches(S: String, words: Array<String>): Int {
    /*
    val list = arrayOfNulls<MutableList<StringCharacterIterator>>(128)
    var c = 0
    while (c <= 'z'.code) {
        list[c] = ArrayList<StringCharacterIterator>()
        c++
    }
    for (word in words) {
        list[word[0].code]!!.add(StringCharacterIterator(word))
    }
    for (c in S.toCharArray()) {
        /*
        This loop iterates over each character in the S string. For each character,
        it retrieves the list of StringCharacterIterator objects corresponding to
        that character from 'list', and initializes a new empty list in its place.
        It then iterates over each StringCharacterIterator in the retrieved list,
        advances it to the next character in the corresponding word, and adds it to
        the appropriate list in 'list' based on the next character's code.
         */
        val advance = list[c.code]!!
        list[c.code] = ArrayList<StringCharacterIterator>()
        for (it in advance) {
            val nextChar = it.next().toInt()
            val index = nextChar and ((StringCharacterIterator.DONE - 1).code)
            list[index]!!.add(it)
        }
    }
    return list[0]!!.size

     */
    val waitingList = HashMap<Int, MutableList<StringCharacterIterator>>()
    for (w in words) {
        val firstChar = w[0].toInt()
        waitingList.getOrPut(firstChar) { mutableListOf() }.add(StringCharacterIterator(w))
    }
    for (c in S.toCharArray()) {
        val advance = waitingList[c.toInt()] ?: continue
        waitingList[c.toInt()] = mutableListOf()
        for (it in advance) {
            val nextChar = it.next()
            if (nextChar != StringCharacterIterator.DONE) {
                waitingList.getOrPut(nextChar.toInt()) { mutableListOf() }.add(it)
            }
        }
    }
    return waitingList[0]?.size ?: 0
}
fun main() {
    val plagiarised = "abcde"
    val students = arrayOf("a", "bb", "acd", "ace")
    print(
        "The content was copied from " + possibleMatches(
            plagiarised,
            students
        ) + " students"
    )
}

