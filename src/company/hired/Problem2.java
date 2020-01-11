package company.hired;

public class Problem2 {
    static int[] dirX = new int[]{1, 0, -1, 0};
    static int[] dirY = new int[]{0, 1, 0, -1};
    static boolean isPossible = false;

    public static boolean solution(long[][] maze, long n) {
        // Type your solution here
        if (maze == null || maze.length == 0) {
            return false;
        }
        boolean[][] visited = new boolean[(int)n][(int)n];
        helper(maze, 0, 0, visited);
        return isPossible;
    }

    public static void helper(long[][] matrix, int row, int col, boolean[][] visited) {
        if (row == matrix.length - 1 && col == matrix[0].length - 1) {
            isPossible = true;
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
            helper(matrix, nextX, nextY, visited);
            visited[row][col] = false;
        }
    }

    public static void main(String[] args) {
        long[][] matrix = new long[][]{
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 0, 0}};
        System.out.println(solution(matrix, 5));
    }
}
