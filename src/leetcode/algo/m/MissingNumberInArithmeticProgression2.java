package leetcode.algo.m;

/**
 * In some array arr, the values were in arithmetic progression: the values arr[i+1] - arr[i] are all equal for every 0 <= i < arr.length - 1.
 * <p>
 * Then, a value from arr was removed that was not the first or last value in the array.
 * <p>
 * Return the removed value.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [5,7,11,13]
 * Output: 9
 * Explanation: The previous array was [5,7,9,11,13].
 * Example 2:
 * <p>
 * Input: arr = [15,13,12]
 * Output: 14
 * Explanation: The previous array was [15,14,13,12].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= arr.length <= 1000
 * 0 <= arr[i] <= 10^5
 * Accepted
 * 3,593
 * Submissions
 * 6,898
 */
public class MissingNumberInArithmeticProgression2 {
    public int missingNumber(int[] A) {
        int first = A[0], last = A[0], sum = 0, n = A.length;
        for (int a : A) {
            first = Math.min(first, a);
            last = Math.max(last, a);
            sum += a;
        }
        return (first + last) * (n + 1) / 2 - sum;
    }

}
