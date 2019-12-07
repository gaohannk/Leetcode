package leetcode.algo.b;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 * <p>
 * For example, given three people living at (0,0), (0,4), and (2,2):
 * <p>
 * 1 - 0 - 0 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
 * <p>
 * Hint:
 * <p>
 * Try to solve it in one dimension first. How can this solution apply to the two dimension case?
 */
public class BestMeetingPoint2 {
    public static int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0)
            return -1;
        int row = grid.length;
        int col = grid[0].length;
        LinkedList<Integer> x = new LinkedList<>();
        LinkedList<Integer> y = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        x.sort(Comparator.comparingInt(i->i));
        y.sort(Comparator.comparingInt(i->i));

        int res = 0, i = 0, j = x.size() - 1;
        while (i < j) {
            res += x.get(j) - x.get(i) + y.get(j) - y.get(i);
            i++;
            j--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
        int res = minTotalDistance(matrix);
        System.out.print(res);
    }

}
