package company;

import java.util.*;

public class CutOffTreesforGolfEvent {
    public static int flatFields(int numRows, int numColumns, List<List<Integer>> fields) {
        PriorityQueue<int[]> treelist = new PriorityQueue<int[]>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] tree1, int[] tree2) {
                        return fields.get(tree1[0]).get(tree1[1]) - fields.get(tree2[0]).get(tree2[1]);
                    }
                });
        int[][] map = new int[numRows][numColumns];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                map[i][j] = fields.get(i).get(j);
                if (fields.get(i).get(j) > 1) {
                    treelist.add(new int[]{i, j});
                }
            }
        }
        int sum = 0;
        int[] start = new int[]{0, 0};
        int[] end = new int[2];
        int res = 0;
        while (!treelist.isEmpty()) {
            end = treelist.remove();
            int tH = map[end[0]][end[1]];
            map[end[0]][end[1]] = 1;
            res = shortestBFS(map, start, end);
            if (res == -1) {
                return -1;
            }
            sum += (res + tH);
            start = end;
        }
        return sum;
    }

    public static int shortestBFS(int[][] maze, int[] start, int[] dest) {
        int m = maze.length, n = maze[0].length;
        int[][] path = new int[m][n];
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int d = 0; d < 4; d++) {
                int x = curr[0], y = curr[1], count = 0;
                while (x + dirs[d][0] >= 0 && x + dirs[d][0] < m && y + dirs[d][1] >= 0 && y + dirs[d][1] < n &&
                        maze[x + dirs[d][0]][y + dirs[d][1]] == 1) {
                    x += dirs[d][0];
                    y += dirs[d][1];
                    count++;
                }
                if ((x != start[0] || y != start[1]) &&
                        (path[x][y] == 0 || path[x][y] > path[curr[0]][curr[1]] + count)) {
                    path[x][y] = path[curr[0]][curr[1]] + count;
                    q.offer(new int[]{x, y});
                }
            }


        }
        return path[dest[0]][dest[1]] == 0 ? -1 : path[dest[0]][dest[1]];
    }
}
