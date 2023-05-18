package dfsbfs

fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
    val dir = intArrayOf(1,0,-1,0,1)
    val m = mat.size-1
    val n = mat[0].size-1
    val deck = ArrayDeque<IntArray>()
    for (r in 0..m){
        for(c in 0..n){
            if(mat[r][c] == 0) deck.add(intArrayOf(r,c))
            else mat[r][c] = -1
        }
    }

    while (!deck.isEmpty()){
        val curr = deck.removeFirst()
        for (i in 0..3){
            val y = curr[0]+dir[i]
            val x = curr[1]+dir[i+1]
            if( x !in 0..n || y !in 0..m || mat[y][x] != -1) continue
            mat[y][x] = mat[curr[0]][curr[1]]+1
            deck.addLast(intArrayOf(y,x))
        }
    }
    return mat
}

fun main() {
    val mat = arrayOf(
        intArrayOf(1,1,0,0,1,0,0,1,1,0),
        intArrayOf(1,0,0,1,0,1,1,1,1,1),
        intArrayOf(1,1,1,0,0,1,1,1,1,0),
        intArrayOf(0,1,1,1,0,1,1,1,1,1),
        intArrayOf(0,0,1,1,1,1,1,1,1,0),
        intArrayOf(1,1,1,1,1,1,0,1,1,1),
        intArrayOf(0,1,1,1,1,1,1,0,0,1),
        intArrayOf(1,1,1,1,1,0,0,1,1,1),
        intArrayOf(0,1,0,1,1,0,1,1,1,1),
        intArrayOf(1,1,1,0,1,0,1,1,1,1)
    )
    println(updateMatrix(mat).contentDeepToString())
}