package dfs

fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
    val currColor = image[sr][sc]
    if (currColor == color) return image
    dfs2(image, sr, sc, currColor, color)
    return image
}

fun dfs2(image: Array<IntArray>, sr: Int, sc: Int, currColor: Int, color: Int) {
    if (sr < 0 || sr >= image.size || sc < 0 || sc >= image[0].size || image[sr][sc] != currColor) return
    image[sr][sc] = color
    dfs2(image, sr-1, sc, currColor, color)
    dfs2(image, sr+1, sc, currColor, color)
    dfs2(image, sr, sc-1, currColor, color)
    dfs2(image, sr, sc+1, currColor, color)
}
fun main() {
    val image = arrayOf(intArrayOf(1,1,1), intArrayOf(1,1,0), intArrayOf(1,0,1))
    val sr = 1
    val sc = 1
    val color = 2
    println(floodFill(image, sr, sc, color).contentDeepToString())
}
