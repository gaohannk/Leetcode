package leetcode.algo.r;

/**
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
 *
 * After doing so, return the array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i] <= 10^5
 */
public class ReplaceElementswithGreatestElementonRightSide2 {
    public int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            if (i == arr.length - 1) {
                arr[i] = -1;
            }
            for (int j = i + 1; j < arr.length; j++) {
                max = Math.max(max, arr[j]);
            }
            arr[i] = max == Integer.MIN_VALUE? -1: max;
        }
        return arr;
    }
}
