package company.amazon.oa;

import java.util.List;

public class NumberOfIslands {
    static boolean[][] visited;
    static int[][] delta = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static int numIslands(List<List<Character>> grid) {
        if (grid.size() == 0)
            return 0;
        int row = grid.size();
        int col = grid.get(0).size();
        visited = new boolean[row][col];

        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid.get(i).get(j) != '0' && !visited[i][j]) {
                    helper(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private static void helper(List<List<Character>> grid, int i, int j) {
        int row = grid.size();
        int col = grid.get(0).size();
        if (visited[i][j] || grid.get(i).get(j) == '0')
            return;
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            if (i + delta[k][0] >= 0 && i + delta[k][0] < row && j + delta[k][1] >= 0 && j + delta[k][1] < col
                    && grid.get(i + delta[k][0]).get(j + delta[k][1]) == '1') {
                helper(grid, i + delta[k][0], j + delta[k][1]);
            }
        }
    }
}
