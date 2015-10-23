package leetcode;
/* A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right 
 * corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 */
/* O(n^2) time, O(n) space
 */
public class UniquePaths4 {
	
	public int uniquePaths(int m, int n) {
        int[] res = new int[n];
         
        // init array
        for(int j = 0; j < n; j++) {
            res[j] = 1;
        }
         
        // add values
        for(int i = 1; i < m; i++) {
            // reset the head to 1 (simulate the next row head)
            // similar to set all left most elements in a 2D array to 1
            res[0] = 1;
            for(int j = 1; j < n; j++) {
                res[j] = res[j - 1] + res[j];
            }
        } 
        return res[n - 1];
    }
}
