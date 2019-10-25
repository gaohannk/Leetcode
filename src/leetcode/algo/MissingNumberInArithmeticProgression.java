package leetcode.algo;

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
public class MissingNumberInArithmeticProgression {
    public int missingNumber(int[] arr) {
        int first = arr[0];
        int last = arr[arr.length - 1];
        int len = arr.length;

        int step = (last - first) / len;

        for (int i = 0; i < len - 1; i++)
            if (arr[i] + step != arr[i + 1])
                return arr[i] + step;

        return 0;
    }

}
