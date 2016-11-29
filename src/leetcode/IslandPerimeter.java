package leetcode;

/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * <p>
 * Example:
 * <p>
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p>
 * Answer: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int res = 0, coverEdge = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res += grid[i][j];
                coverEdge += grid[i][j] == 0 ? 0 : getCoverEdge(grid, i, j);
            }
        }
        return 4 * res - coverEdge;
    }

    private int getCoverEdge(int[][] grid, int row, int col) {
        int count = 0;
        if (row - 1 >= 0 && grid[row - 1][col] == 1)
            count++;
        if (row + 1 < grid.length && grid[row + 1][col] == 1)
            count++;
        if (col - 1 >= 0 && grid[row][col - 1] == 1)
            count++;
        if (col + 1 < grid[0].length && grid[row][col + 1] == 1)
            count++;
        return count;
    }
}
