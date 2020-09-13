package leetcode.algo;

/**
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 *
 * Find the kth positive integer that is missing from this array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,3,4,7,11], k = 5
 * Output: 9
 * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
 * Example 2:
 *
 * Input: arr = [1,2,3,4], k = 2
 * Output: 6
 * Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 1 <= k <= 1000
 * arr[i] < arr[j] for 1 <= i < j <= arr.length
 */
public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        // The nth missing number
        int missing = 0;
        // current number
        int count = 1;

        for (int value : arr) {
            while (value != count) {
                missing++;
                if (missing == k) {
                    return count;
                }
                count++;
            }
            count++;
        }
        return count - 1 + (k - missing);
    }
}
