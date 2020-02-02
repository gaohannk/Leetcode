package leetcode.algo.n;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands3 {
    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        boolean[][] checker = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != '0' && checker[i][j] == false) {
                    checker[i][j] = true;
                    bfs(checker, grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void bfs(boolean[][] checker, char[][] grid, int startX, int startY) {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.offer(startX);
        qy.offer(startY);
        int row = grid.length;
        int col = grid[0].length;

        while (!qx.isEmpty() && !qy.isEmpty()) {
            Queue<Integer> nextX = new LinkedList<>();
            Queue<Integer> nextY = new LinkedList<>();

            while (!qx.isEmpty() && !qy.isEmpty()) {
                int i = qx.poll();
                int j = qy.poll();
                if (j + 1 < col && grid[i][j + 1] == '1' && !checker[i][j + 1]) {
                    nextX.add(i);
                    nextY.add(j + 1);
                    checker[i][j + 1] = true;
                }
                if (j - 1 >= 0 && grid[i][j - 1] == '1' && !checker[i][j - 1]) {
                    nextX.add(i);
                    nextY.add(j - 1);
                    checker[i][j - 1] = true;
                }
                if (i + 1 < row && grid[i + 1][j] == '1' && !checker[i + 1][j]) {
                    nextX.add(i + 1);
                    nextY.add(j);
                    checker[i + 1][j] = true;
                }
                if (i - 1 >= 0 && grid[i - 1][j] == '1' && !checker[i - 1][j]) {
                    nextX.add(i - 1);
                    nextY.add(j);
                    checker[i - 1][j] = true;
                }
            }
            qx = nextX;
            qy = nextY;
        }
    }
}
