package leetcode

fun updateVLAN(matrix: Array<IntArray>, r: Int, c: Int, newID: Int): Array<IntArray> {
    /*
    we can move in at most four directions from each cell, i.e., up, down, left, and right.
    To move to another cell, the neighboring cell must have a VLAN ID equal to the current cell’s ID.
    In this case, we’ll simply call DFS on the provided cell, and it will recursively assign the
    new ID to its neighbors. We also need to make sure that we don’t process a cell whose ID has
    already been changed.
     */
    val currId = matrix[r][c]
    if (currId == newID) return matrix
    dfs(matrix, r, c, currId, newID)
    return matrix
}
fun dfs(matrix: Array<IntArray>, r: Int, c: Int, currId: Int, newID: Int) {
    /*
    r < 0 || c < 0 : If either the row or column index is less than zero, then the element
    is outside the bounds of the matrix and cannot be updated. This check ensures that we
    don't attempt to access elements outside the matrix bounds, which would result in an index
    out of bounds error.

    r >= matrix.size || c >= matrix[0].size : If either the row or column index is greater
    than or equal to the size of the matrix, then the element is outside the bounds of the
    matrix and cannot be updated. This check ensures that we don't attempt to access elements
    outside the matrix bounds, which would result in an index out of bounds error.

    matrix[r][c] != currID : If the current element's ID does not match the currID passed to
    the dfs function, then the element is not part of the connected component that we want to
    update, and we can skip it. This check ensures that we only update elements that are connected
    to the starting element with currID.

    If any of these conditions are true, then the function immediately returns, skipping
    the update for the current element.
     */
   if (r < 0 || c < 0 || r >= matrix.size || c >= matrix[0].size || matrix[r][c] != currId)
       return

    matrix[r][c] = newID

    dfs(matrix, r-1, c, currId, newID) // up
    dfs(matrix, r+1, c, currId, newID) // down
    dfs(matrix, r, c-1, currId, newID) // left
    dfs(matrix, r, c+1, currId, newID) // right
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(1, 1, 1, 1, 0),
        intArrayOf(1, 1, 1, 0, 0),
        intArrayOf(1, 1, 0, 1, 0),
        intArrayOf(1, 1, 0, 0, 1)
    )
    val r = 1
    val c = 1
    val newID = 2
    println(
        """Swtches with Updated VLAN IDs:
 ${updateVLAN(matrix, r, c, newID).contentDeepToString()}"""
    )
}
