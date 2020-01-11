package company.offerup.phone;

import java.util.LinkedList;
import java.util.List;

public class ShortestPath3 {
    static int[] dirX = new int[]{1, 0, -1, 0};
    static int[] dirY = new int[]{0, 1, 0, -1};
    static int min = Integer.MAX_VALUE;
    static List<int[]> shortestPath;

    public static List<int[]> shortestPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new LinkedList<>();
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<int[]> path = new LinkedList<>();
        helper(matrix, 0, 0, 0, visited, path);
        return shortestPath;
    }

    private static void helper(int[][] matrix, int dis, int row, int col, boolean[][] visited, List<int[]> path) {
        if (row == matrix.length - 1 && col == matrix[0].length - 1) {
            if (dis < min) {
                min = Math.min(min, dis);
                shortestPath = path;
            }
            return;
        }
        if (visited[row][col]) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextX = row + dirX[i];
            int nextY = col + dirY[i];
            if (nextX >= matrix.length || nextX < 0 || nextY >= matrix[0].length || nextY < 0) {
                continue;
            }
            if (matrix[nextX][nextY] == 1) {
                continue;
            }
            visited[row][col] = true;
            path.add(new int[]{row, col});
            helper(matrix, dis + 1, nextX, nextY, visited, path);
            path.remove(path.size() - 1);
            visited[row][col] = false;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 0, 0}};
        System.out.println(shortestPath(matrix));
    }
}
