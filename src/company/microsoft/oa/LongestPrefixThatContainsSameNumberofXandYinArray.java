package company.microsoft.oa;

/**
 * Given two positive integers X and Y, and an array arr[] of positive integers. We need to find the longest prefix index which contains an equal number of X and Y. Print the maximum index of largest prefix if exist otherwise print -1.
 *
 * Examples:
 *
 * Input : array[] = [7, 42, 5, 6, 42, 8, 7, 5, 3, 6, 7]
 * X = 7 Y = 42
 * Output : 9
 * The longest prefix with same number of occurrences
 * of 7 and 42 is:
 * 7, 42, 5, 6, 42, 8, 7, 5, 3, 6
 */
public class LongestPrefixThatContainsSameNumberofXandYinArray {

    static int findIndex(int[] arr, int X, int Y, int n) {
        // counters for X and Y
        int countX = 0, countY = 0;
        int res = -1;
        for (int i = 0; i < n; i++) {
            // If value is equal to X
            // increment counter of X
            if (arr[i] == X) {
                countX++;
            }

            // If value is equal to Y
            // increment counter of Y
            if (arr[i] == Y) {
                countY++;
            }

            // If counters are equal(but not
            // zero) save the res as i
            if ((countX != 0) && (countX == countY)) {
                res = i;
            }
        }

        return res;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {7, 42, 5, 6, 42, 8,
                7, 5, 3, 6, 7};
        int X = 7, Y = 42;
        int n = arr.length;
        System.out.println("Ending index of prefix is " + findIndex(arr, X, Y, n));
    }
}
