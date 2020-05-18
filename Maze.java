public class Maze {

    public Tile[][] grid;
    public int size = 0;

    public Maze(int inputSize) {
        size = inputSize;
        grid = new Tile[size][size];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                int randint = (int) Math.floor(Math.random() * 10);
                grid[row][col] = (randint == 1) ? new Bomb(row, col) : new Tile(row, col);
            }
        }
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                setNeighbours(row, col);
                grid[row][col].numBombs = countBombs(row, col);
            }
        }
    }

    private void setNeighbours(int paramRow, int paramCol) {
        for (int row = -1; row < 2; row++) {
            for (int col = -1; col < 2; col++) {
                if (row == -1 && col == 0) {
                    if (paramRow + row >= 0) {
                        grid[paramRow][paramCol].setNeighbour(grid[paramRow + row][paramCol + col], "north");
                    }
                } else if (row == 0 && col == 1) {
                    if (paramCol + col < size) {
                        grid[paramRow][paramCol].setNeighbour(grid[paramRow + row][paramCol + col], "east");
                    }
                } else if (row == 1 && col == 0) {
                    if (paramRow + row < size) {
                        grid[paramRow][paramCol].setNeighbour(grid[paramRow + row][paramCol + col], "south");
                    }
                } else if (row == 0 && col == -1) {
                    if (paramCol + col >= 0) {
                        grid[paramRow][paramCol].setNeighbour(grid[paramRow + row][paramCol + col], "west");
                    }
                }
            }
        }
    }

    public Tile[][] getMazeGrid() {
        return grid;
    }

    private int countBombs(int paramRow, int paramCol) {
        int count = 0;
        for (int row = -1; row < 2; row++) {
            for (int col = -1; col < 2; col++) {
                if (paramRow + row >= 0 && paramCol + col < size && paramRow + row < size && paramCol + col >= 0) {
                    if (grid[paramRow + row][paramCol + col].isBomb()) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

}