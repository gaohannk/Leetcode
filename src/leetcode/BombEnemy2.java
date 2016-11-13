package leetcode;

/** We have a 2D grid. Each cell is either a wall, an enemy or empty.
 * For example (0-empty, X-enemy, Y-wall):
 * 0 X 0 0
 * X 0 Y X
 * 0 X 0 0
 * You have one bomb and you want to kill as many as possible enemies with it. The bomb will kill all the enemies in the same row and columnfrom the planted point until it hits the wall since the wall is too strong to be destroyed.
 * Given such a grid, return the maximum enemies you can kill with one bomb.
 * Note that you can only put the bomb at empty cell.
 * In the example, if you put a bomb at (1,1) you will kill 3 enemies which is the best you can get. You can not kill the guy behind the wall at (1,3).
 * */
/*这道题的思想就是遍历数组中的每一个点，当前点能够得到的最大值为从左边的头（边界或wall）到右边的头（遇到边界或wall）的值（row值）＋从上面的头（边界或wall）到下面的头（遇到边界或wall）的值（col值）。每一个row范围内的点都共用当前的row值，每一个col范围内的点都共用当前col值。当从新的边界或者wall开始时，相当于进入了新的一段范围，要重新计算row值或者col值。
遍历数组中每一个点，若为0则开始计算+

若当前点为第一列或者左边一个点为wall，表明进入了一个新的区间，需要重新计算。从该点开始一直向右直到遇到边界或者wall，在该过程中，每遇到一个E就将row值＋1
若当前点为第一行或者上边一个点为wall，表明进入了一个新的区间，需要重新计算。从该点开始一直向下直到遇到边界或者wall，在该过程中，每遇到一个E就将col值＋1
重复2-3步骤
*/
public class BombEnemy2 {
    public int maxKilledEnemies(char[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int result = 0;
        int rows = 0;
        int[] cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // calculate enemy in row
                if (j == 0 || grid[i][j - 1] == 'Y') {
                    rows = 0;
                    for (int k = j; k < n && grid[i][k] != 'Y'; k++) {
                        if (grid[i][k] == 'E')
                            rows++;
                    }
                }
                // calculate enemy in col
                if (i == 0 || grid[i - 1][j] == 'Y') {
                    cols[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'Y'; k++) {
                        if (grid[k][j] == 'E')
                            cols[j]++;
                    }
                }
                if (grid[i][j] == '0' && rows + cols[j] > result)
                    result = rows + cols[j];
            }
        }
        return result;

    }
}
