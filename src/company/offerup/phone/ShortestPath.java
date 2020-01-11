package company.offerup.phone;

public class ShortestPath {
    static int[] dirX = new int[]{1, 0, -1, 0};
    static int[] dirY = new int[]{0, 1, 0, -1};
    static int min = Integer.MAX_VALUE;

    public static int shortestPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        helper(matrix, 0, 0, 0, visited);

        return min;
    }

    private static void helper(int[][] matrix, int dis, int row, int col, boolean[][] visited) {
        if (row == matrix.length-1 && col == matrix[0].length-1) {
            min = Math.min(min, dis);
            return;
        }
        if(visited[row][col]){
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
            helper(matrix, dis + 1, nextX, nextY, visited);
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
