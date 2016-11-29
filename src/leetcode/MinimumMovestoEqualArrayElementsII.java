package leetcode;

import java.util.Arrays;

/**
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 * <p>
 * You may assume the array's length is at most 10,000.
 * <p>
 * Example:
 * <p>
 * Input:
 * [1,2,3]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 * <p>
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
public class MinimumMovestoEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        if (nums == null)
            return 0;
        Arrays.sort(nums);
        int len = nums.length;
        int sum = 0;
        int target = nums[len / 2];
        for (int i = 0; i < len; i++) {
            sum += Math.abs(nums[i] - target);
        }
        return sum;
    }
}
