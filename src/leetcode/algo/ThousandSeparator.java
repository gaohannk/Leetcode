package leetcode.algo;

/**
 * Given an integer n, add a dot (".") as the thousands separator and return it in string format.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 987
 * Output: "987"
 * Example 2:
 *
 * Input: n = 1234
 * Output: "1.234"
 * Example 3:
 *
 * Input: n = 123456789
 * Output: "123.456.789"
 * Example 4:
 *
 * Input: n = 0
 * Output: "0"
 *
 *
 * Constraints:
 *
 * 0 <= n < 2^31
 */
public class ThousandSeparator {
    public String thousandSeparator(int n) {
        StringBuilder nums = new StringBuilder(Integer.toString(n)); // Convert Integer to String
        int count = 0;
        if (nums.length() <= 3)
            return nums.toString(); // If it is a number having less than or equal 3 digits return it.
        for (int i = nums.length() - 1; i >= 1; i--) { // Do not disturb the first character. Thus looping till 1.
            count++;
            if (count == 3) {
                nums.insert(i, "."); // For every 3 digits from the end, insert a "dot"
                count = 0; // reset the count so that we can count till 3 again to insert the dot.
            }
        }
        return nums.toString(); // Return the thousand separated string
    }
}
