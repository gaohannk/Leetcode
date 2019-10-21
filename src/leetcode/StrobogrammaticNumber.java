package leetcode;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * <p>
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * <p>
 * Example 1:
 * <p>
 * Input:  "69"
 * Output: true
 * Example 2:
 * <p>
 * Input:  "88"
 * Output: true
 * Example 3:
 * <p>
 * Input:  "962"
 * Output: false
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        String A = "01689";
        String B = "01986";
        int i = 0;
        int j = num.length() - 1;
        while (i <= j) {
            int k = A.indexOf(num.charAt(i));
            if (k == -1 || num.charAt(j) != B.charAt(k))
                return false;
            ++i;
            --j;
        }

        return true;
    }
}
