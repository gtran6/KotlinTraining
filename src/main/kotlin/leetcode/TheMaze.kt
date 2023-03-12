package leetcode

internal object Solution {
    fun hasPath(maze: List<List<Int>>, start: List<Int>, end: List<Int>): Boolean {
        //creates a 2D boolean array with maze.size number of rows and maze[0].size number of columns, where each element is initialized to false.
        val visitedPlace: Array<BooleanArray> = Array(maze.size) { BooleanArray(maze[0].size) }
        return path(maze, start, end, visitedPlace)
    }

    private fun path(
        maze: List<List<Int>>,
        start: List<Int>,
        end: List<Int>,
        visitedPlace: Array<BooleanArray>
    ): Boolean {
        //This checks if the starting point has already been visited. If it has been visited, it returns false as there is no need to continue exploring this path.
        if (visitedPlace[start[0]][start[1]])
            return false
        //This checks if the starting point is the same as the ending point. If it is, it returns true as we have found a path from start to end.
        if (start[0] == end[0] && start[1] == end[1])
            return true
        //This sets the visited place to true as we are exploring this path.
        visitedPlace[start[0]][start[1]] = true
        var r = start[1] + 1
        var l = start[1] - 1
        var u = start[0] - 1
        var d = start[0] + 1

        //This is a while loop that checks if the current row u is greater than or equal to 0
        // and the value of the maze at that position is 0 (checks if there is am empty space). It keeps moving up as long as these conditions are met.

        //u >= 0: This checks that we have not reached the top of the maze list. If u is less than 0,
        // we have reached the top of the maze and cannot move up anymore.
        //maze[u][start[1]] == 0: This checks if we can move up from the current position by checking if the value of maze[u][start[1]] is equal to 0.
        // If this condition is false, it means there is a wall or an obstacle blocking the way, and we cannot move up in that direction.
        while (u >= 0 && maze[u][start[1]] == 0) //up
            u--; //This decrements the value of u so that it moves up one row.
        //This is a recursive call to the "path" function with updated start coordinates at the position above
        // the current position. If there is a path, it returns true.
        if (path(maze, listOf(u + 1, start[1]), end, visitedPlace))
            return true;

        // This is a while loop that checks if the current row d is less than the number of rows
        // and the value of the maze at that position is 0. It keeps moving down as long as these conditions are met.

        // d < maze.size: This checks that we have not reached the bottom of the maze list.
        // If d is equal to or greater than the length of the maze list, we have reached the bottom of the maze and cannot move down anymore.
        // maze[d][start[1]] == 0: This checks if we can move down from the current position by checking if the value of maze[d][start[1]]
        // is equal to 0. If this condition is false, it means there is a wall or an obstacle blocking the way, and we cannot move down in that direction.
        while (d < maze.size && maze[d][start[1]] == 0) //down
            d++; // This increments the value of d so that it moves down one row.
        // This is a recursive call to the "path" function with updated start coordinates at the position below
        // the current position. If there is a path, it returns true.
        if (path(maze, listOf(d - 1, start[1]), end, visitedPlace))
            return true;

        // this is a while loop that checks if the current column l is greater than or equal to 0
        // and the value of the maze at that position is 0. It keeps moving left as long as these conditions are met
        while (l >= 0 && maze[start[0]][l] == 0) //left
            l--; // decrements the value of l so that it goes left one column
        // this is a recursive call to the "path" function with updated start coordinates at the position to the left
        // of the current position. if there is a path, it returns true
        if (path(maze, listOf(start[0], l + 1), end, visitedPlace))
            return true;

        // This is a while loop that checks if the current column r is less than the number of columns
        // and the value of the maze at that position is 0. It keeps moving right as long as these conditions are met.
        while (r < maze[0].size && maze[start[0]][r] == 0) // right
            r++; // This increments the value of r so that it goes right 1 column
        // this is a recursive call to the "path" function with updated start coordinates at the position to the right
        // of the current position. if there is a path, it returns true
        if (path(maze, listOf(start[0], r - 1), end, visitedPlace))
            return true;
        return false;
        //visitedPlace[start[0]][start[1]] checks the value in the visitedPlace array at the position corresponding
    // to the starting point. If it is true, that means the starting point has already been visited and the function returns false.
    }
}

fun main() {
    var maze = listOf(
        listOf(0,0,0,0,1),
        listOf(0,0,1,1,1),
        listOf(0,0,0,0,0),
        listOf(1,1,1,1,0),
        listOf(0,0,0,0,0));
    var start = listOf(0,3);
    var end = listOf(4,0);

    println(Solution.hasPath(maze, start, end));
}
