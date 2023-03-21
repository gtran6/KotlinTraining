package leetcode.Facebook

fun smallestSequence(listA: Array<String>, listB: Array<String>): Array<String?> {
    // Returns an empty list if one or more list is empty.
    if (listA.isEmpty() || listB.isEmpty()) {
        return arrayOfNulls(0)
    }

    // We will use this dictionary to keep a count of all unique topics in list b.
    val dictListB: MutableMap<String?, Int> = HashMap()
    for (i in listB.indices) {
        val count = dictListB.getOrDefault(listB[i], 0)
        dictListB[listB[i]] = count + 1
    }

    // This will hold the count of number of unique topics in list b.
    val countUniqueB = dictListB.size

    // uniqueCharacters keeps a count of the number of unique characters of list_b which are present in the current with its required frequency.
    var uniqueCharacters = 0

    // This dictionary holds the count of all the unique topics in the current window.
    val uniqueTopics: MutableMap<String?, Int> = HashMap()

    // Checks and appends a topic along with its index from list A in sifted list, if the topic is present in list B.
    val siftedListA: MutableList<HashMap<Int, String>> = ArrayList()
    for (i in listA.indices) {
        val str = listA[i]
        if (dictListB.containsKey(str)) {
            val tempMap = HashMap<Int, String>()
            tempMap[i] = str
            siftedListA.add(tempMap)
        }
    }

    // A tuple that is used to store the window length, left, right
    val tupleWllr = intArrayOf(-1, 0, 0)

    // Left and right pointers
    var left = 0
    var right = 0

    // Look for the topics only in the filtered list instead of entire list.
    while (right < siftedListA.size) {
        // Add one topic from the right to the window
        val rightKey = siftedListA[right].keys.stream().findFirst().get()
        var topic = siftedListA[right][rightKey]
        val count = uniqueTopics.getOrDefault(topic, 0)
        uniqueTopics[topic] = count + 1

        // Checking the frequency of the currently added topic.
        // If it is equal to the desired count in our list_b then we are incrementing the value of unique_characters.
        if (dictListB.containsKey(topic) && uniqueTopics[topic]!!.toInt() == dictListB[topic]!!
                .toInt()
        ) {
            uniqueCharacters++
        }

        // If the current window has all the topics in desired frequencies i.e. it is present in the window
        while (left <= right && uniqueCharacters == countUniqueB) {
            // topic = siftedListA.get(left).getValue();
            val leftKey = siftedListA[left].keys.stream().findFirst().get()
            topic = siftedListA[left][leftKey]

            // Save the smallest window until now.
            val endSequence = siftedListA[right].keys.toTypedArray()[0]
            val startSequence = siftedListA[left].keys.toTypedArray()[0]
            if (tupleWllr[0] == -1 || endSequence - startSequence + 1 < tupleWllr[0]) {
                tupleWllr[0] = endSequence - startSequence + 1
                tupleWllr[1] = startSequence
                tupleWllr[2] = endSequence
            }

            // The character at the position pointed by the `left` pointer is no longer a part of the window.
            uniqueTopics[topic] = uniqueTopics[topic]!! - 1
            if (dictListB.containsKey(topic) && uniqueTopics[topic]!!.toInt() < dictListB[topic]!!
                    .toInt()
            ) {
                uniqueCharacters--
            }

            // Moving the left pointer ahead.
            left++
        }

        // Moving the right pointer ahead.
        right++
    }
    return if (tupleWllr[0] == -1) {
        arrayOfNulls(0)
    } else {
        val res = arrayOfNulls<String>(tupleWllr[2] + 1 - tupleWllr[1])
        var j = 0
        var i = tupleWllr[1]
        while (i < tupleWllr[2] + 1) {
            res[j] = listA[i]
            i++
            j++
        }
        res
    }
}
fun main() {
    val a = arrayOf("corona", "petrol", "corona", "corona", "climate", "petrol", "corona", "petrol")
    val b = arrayOf("corona", "petrol", "climate")
    val output = smallestSequence(a, b)
    println(output.contentToString())
}