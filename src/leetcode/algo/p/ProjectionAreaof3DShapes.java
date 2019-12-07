package leetcode.algo.p;

public class ProjectionAreaof3DShapes {
    public int projectionArea(int[][] grid) {
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0)
                    area++;
                max = Math.max(max, grid[i][j]);
            }
            area += max;
        }
        for (int j = 0; j < grid[0].length; j++) {
            int max = 0;
            for (int i = 0; i < grid.length; i++) {
                max = Math.max(max, grid[i][j]);
            }
            area += max;
        }
        return area;
    }
}
