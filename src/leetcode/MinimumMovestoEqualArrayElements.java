package leetcode;

/**
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 * <p>
 * Example:
 * <p>
 * Input:
 * [1,2,3]
 * <p>
 * Output:
 * 3
 * <p>
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * <p>
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class MinimumMovestoEqualArrayElements {
    public int minMoves(int[] nums) {
        if (nums.length == 1)
            return 0;
        int sum = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = min > nums[i] ? nums[i] : min;
        }
        sum -= min * (nums.length - 1);
        return sum;
    }
}
