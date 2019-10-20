package leetcode.m;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
 * <p>
 * Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
 * <p>
 * a, b are from arr
 * a < b
 * b - a equals to the minimum absolute difference of any two elements in arr
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [4,2,1,3]
 * Output: [[1,2],[2,3],[3,4]]
 * Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
 * Example 2:
 * <p>
 * Input: arr = [1,3,6,10,15]
 * Output: [[1,3]]
 * Example 3:
 * <p>
 * Input: arr = [3,8,-10,23,19,-4,-14,27]
 * Output: [[-14,-10],[19,23],[23,27]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 */
public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        // sort array
        Arrays.sort(arr);

        int diff = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // Iterate through array to find the smallest difference
        for (int i = 0; i < arr.length - 1; i++) {
            diff = Math.min(diff, arr[i + 1] - arr[i]);
        }

        // Iterate through array again to see if any pairs have the same difference
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == diff) {
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                ans.add(pair);
            }
        }
        return ans;
    }
}
