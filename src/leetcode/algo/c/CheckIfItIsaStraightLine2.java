package leetcode.algo.c;

/**
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 */
public class CheckIfItIsaStraightLine2 {
    public boolean checkStraightLine(int[][] coord) {
        int dx = coord[0][0] - coord[1][0];
        int dy = coord[0][1] - coord[1][1];

        for (int i = 2; i < coord.length; ++i) {
            if ((coord[i][0] - coord[0][0]) * dy != (coord[i][1] - coord[0][1]) * dx) {
                return false;
            }
        }

        return true;
    }
}
