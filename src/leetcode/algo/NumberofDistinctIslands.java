package leetcode.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.
 *
 * Example 1:
 * 11000
 * 11000
 * 00011
 * 00011
 * Given the above grid map, return 1.
 * Example 2:
 * 11011
 * 10000
 * 00001
 * 11011
 * Given the above grid map, return 3.
 *
 * Notice that:
 * 11
 * 1
 * and
 *  1
 * 11
 * are considered different island shapes, because we do not consider reflection / rotation.
 */
public class NumberofDistinctIslands {
    int[][] grid;
    boolean[][] seen;
    Set<Integer> shape;

    public void helper(int i, int j, int i0, int j0) {
        if (0 <= i && i < grid.length && 0 <= j && j < grid[0].length && grid[i][j] == 1 && !seen[i][j]) {
            seen[i][j] = true;
            shape.add((i - i0) * 2 * grid[0].length + (j - j0));
            helper(i+1, j, i0, j0);
            helper(i-1, j, i0, j0);
            helper(i, j+1, i0, j0);
            helper(i, j-1, i0, j0);
        }
    }
    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        Set<Set<Integer>> shapes = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                shape = new HashSet<>();
                helper(i, j, i, j);
                if (!shape.isEmpty()) {
                    shapes.add(shape);
                }
            }
        }

        return shapes.size();
    }
}
