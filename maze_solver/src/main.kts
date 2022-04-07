import kotlin.random.Random.Default.nextInt

data class Cell(
    var top: Boolean = true,
    var bottom: Boolean = true,
    var left: Boolean = true,
    var right: Boolean = true,
    var visited: Boolean = false,
)

class Maze(private val gridSize: Int) {
    var maze: Array<Array<Cell>>

    init {
        maze = Array(gridSize) { Array(gridSize) { Cell() } }
        generate(0, 0)
    }

    fun printMaze() {
        for (i in 0 until gridSize * 3) {
            print("X")
        }
        println()
        for (i in 0 until gridSize) {
            for (j in 0 until gridSize) {
                if (j == 0) {
                    print("X")
                }
                if (maze[i][j].right) {
                    print(" X")
                } else {
                    print("  ")
                }
                if (j == gridSize - 1) {
                    print(" X")
                }
            }
            println()
        }
        for (i in 0 until gridSize * 3) {
            print("X")
        }
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

