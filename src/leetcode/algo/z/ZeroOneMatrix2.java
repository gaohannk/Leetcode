package leetcode.algo.z;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * <p>
 * The distance between two adjacent cells is 1.
 * Example 1:
 * Input:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * Output:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * Example 2:
 * Input:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * Output:
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * Note:
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right
 */
// Start from value is 0, BFS
public class ZeroOneMatrix2 {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] output = new int[matrix.length][matrix[0].length];
        boolean visited[][] = new boolean[matrix.length][matrix[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] neighbor : getNeighbors(cell, visited)) {
                visited[neighbor[0]][neighbor[1]] = true;
                output[neighbor[0]][neighbor[1]] = output[cell[0]][cell[1]] + 1;
                queue.offer(neighbor);
            }
        }
        return output;
    }

    List<int[]> getNeighbors(int[] cell, boolean visited[][]) {

        List<int[]> list = new LinkedList<>();
        if (cell[0] != 0 && !visited[cell[0] - 1][cell[1]])
            list.add(new int[]{cell[0] - 1, cell[1]});
        if (cell[0] != visited.length - 1 && !visited[cell[0] + 1][cell[1]])
            list.add(new int[]{cell[0] + 1, cell[1]});
        if (cell[1] != 0 && !visited[cell[0]][cell[1] - 1])
            list.add(new int[]{cell[0], cell[1] - 1});
        if (cell[1] != visited[0].length - 1 && !visited[cell[0]][cell[1] + 1])
            list.add(new int[]{cell[0], cell[1] + 1});
        return list;
    }
}
