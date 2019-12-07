package leetcode.algo.c;

/**
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
 *
 *
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 * Example 2:
 *
 *
 *
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 */
public class CheckIfItIsaStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        double xDifference = coordinates[1][0] - coordinates[0][0];
        double yDifference = coordinates[1][1] - coordinates[0][1];
        double slope = yDifference / xDifference;

        for (int i = 2; i < coordinates.length; i++) {
            double localXDifference = coordinates[i][0] - coordinates[i-1][0];
            double localYDifference = coordinates[i][1] - coordinates[i-1][1];
            if (localYDifference / localXDifference != slope) {
                return false;
            }
        }

        return true;
    }
}
