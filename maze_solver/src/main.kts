import kotlin.random.Random.Default.nextInt

data class Cell(
    var top: Boolean = true,
    var bottom: Boolean = true,
    var left: Boolean = true,
    var right: Boolean = true,
    var visited: Boolean = false,
)

class Maze(private val gridSize: Int) {
    private var maze = Array(gridSize) { Array(gridSize) { Cell() } }

    init {
        generate(0, 0)
    }

    fun printMaze() {
        for (i in maze.indices) {
            val row = maze[i]
            printTop(row)
            printMiddle(row)
            if (i == maze.size - 1) {
                printBottom(row)
            }
        }
    }

    private fun printTop(row: Array<Cell>) {
        for (cell in row) {
            print(if (cell.top) "+--" else "+  ")
        }
        println("+")
    }

    private fun printMiddle(row: Array<Cell>) {
        for (i in row.indices) {
            val cell = row[i]
            print(if (cell.left) "|  " else "   ")
            if (i == row.size - 1) {
                println(if (cell.right) "|" else " ")
            }
        }
    }

    private fun printBottom(row: Array<Cell>) {
        for (cell in row) {
            print(if (cell.bottom) "+--" else "+  ")
        }
        println("+")
    }

    private fun generate(row: Int, col: Int) {
        maze[row][col].visited = true

        while ((withinBounds(row + 1, col) && !maze[row + 1][col].visited)
            || (withinBounds(row - 1, col) && !maze[row - 1][col].visited)
            || (withinBounds(row, col + 1) && !maze[row][col + 1].visited)
            || (withinBounds(row, col - 1) && !maze[row][col - 1].visited)
        ) {
            while (true) {
                val randomChoice = nextInt(until = 4)
                if (randomChoice == 0 && withinBounds(row, col + 1) && !maze[row][col + 1].visited) {
                    maze[row][col].right = false
                    maze[row][col + 1].left = false
                    generate(row, col + 1)
                    break
                } else if (randomChoice == 1 && withinBounds(row + 1, col) && !maze[row + 1][col].visited) {
                    maze[row][col].bottom = false
                    maze[row + 1][col].top = false
                    generate(row + 1, col)
                    break
                } else if (randomChoice == 2 && withinBounds(row, col - 1) && !maze[row][col - 1].visited) {
                    maze[row][col].left = false
                    maze[row][col - 1].right = false
                    generate(row, col - 1)
                    break
                } else if (randomChoice == 3 && withinBounds(row - 1, col) && !maze[row - 1][col].visited) {
                    maze[row][col].top = false
                    maze[row - 1][col].bottom = false
                    generate(row - 1, col)
                    break
                }
            }
        }
    }

    private fun withinBounds(row: Int, col: Int): Boolean {
        if (row < 0 || row == gridSize || col < 0 || col == gridSize) {
            return false
        }
        return true
    }
}

Maze(3).printMaze()

