package leetcode

fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
    val currColor = image[sr][sc]
    if (currColor == newColor) return image
    dfs1(image, sr, sc, currColor, newColor)
    return image
}

fun dfs1(image: Array<IntArray>, sr: Int, sc: Int, currColor: Int, newColor: Int) {
    if (sr < 0 || sc < 0 || sr >= image.size || sc >= image[0].size || image[sr][sc] != currColor)
        return
    image[sr][sc] = newColor
    dfs1(image, sr-1, sc, currColor, newColor)
    dfs1(image, sr+1, sc, currColor, newColor)
    dfs1(image, sr, sc-1, currColor, newColor)
    dfs1(image, sr, sc+1, currColor, newColor)
}
fun main() {
    val image = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 1, 0),
        intArrayOf(1, 0, 1),
    )
    val r = 1
    val c = 1
    val newColor = 2
    println(floodFill(image, r, c, newColor).contentDeepToString())
}
/*
The time complexity of the updateVLAN function is O(N * M), where N is
the number of rows in the matrix and M is the number of columns in the matrix

The space complexity of the updateVLAN function is also O(N * M), because the DFS algorithm
uses the call stack to keep track of the elements that need to be visited.
 */

