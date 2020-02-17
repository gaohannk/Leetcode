package company.amazon.oa;

import java.util.*;

/**
 * Given a 2D grid, each cell is either a zombie 1 or a human 0. Zombies can turn adjacent (up/down/left/right) human beings into zombies every hour. Find out how many hours does it take to infect all humans?
 *
 * Example:
 *
 * Input:
 * [[0, 1, 1, 0, 1],
 * [0, 1, 0, 1, 0],
 * [0, 0, 0, 0, 1],
 * [0, 1, 0, 0, 0]]
 *
 * Output: 2
 *
 * Explanation:
 * At the end of the 1st hour, the status of the grid:
 * [[1, 1, 1, 1, 1],
 * [1, 1, 1, 1, 1],
 * [0, 1, 0, 1, 1],
 * [1, 1, 1, 0, 1]]
 *
 * At the end of the 2nd hour, the status of the grid:
 * [[1, 1, 1, 1, 1],
 * [1, 1, 1, 1, 1],
 * [1, 1, 1, 1, 1],
 * [1, 1, 1, 1, 1]]
 * int minHours(int rows, int columns, List<List<Integer>> grid) {
 *
 * }
 */
public class Zombee {
    static int minHours(int rows, int columns, List<List<Integer>> grid) {
        if (rows == 0 || columns == 0) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid.get(i).get(j) == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int hour = 0;

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            hour++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                for (int[] dir : dirs) {
                    if (cur[0] + dir[0] < 0 || cur[0] + dir[0] >= rows || cur[1] + dir[1] < 0 || cur[1] + dir[1] >= columns
                            || grid.get(cur[0] + dir[0]).get(cur[1] + dir[1]) == 1) { // don't find zombee, find human
                        continue;
                    }
                    grid.get(cur[0] + dir[0]).remove(cur[1] + dir[1]);
                    grid.get(cur[0] + dir[0]).add(cur[1] + dir[1], 1);
                    queue.offer(new int[]{cur[0] + dir[0], cur[1] + dir[1]});
                }
            }
        }
        return hour - 1;
    }

    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        item.add(0);
        item.add(1);
        item.add(1);
        item.add(0);
        item.add(1);
        grid.add(item);
        item = new ArrayList<>();
        item.add(0);
        item.add(1);
        item.add(0);
        item.add(1);
        item.add(0);
        grid.add(item);
        item = new ArrayList<>();
        item.add(0);
        item.add(0);
        item.add(0);
        item.add(0);
        item.add(1);
        grid.add(item);
        item = new ArrayList<>();
        item.add(0);
        item.add(1);
        item.add(0);
        item.add(0);
        item.add(0);
        grid.add(item);
        System.out.println(minHours(4, 5, grid));
    }
}
