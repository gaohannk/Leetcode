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
public class StrobogrammaticNumber2 {
    public boolean isStrobogrammatic(String num) {
        StringBuilder sb = new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            String rotatedDigit = rotateDigit(num.charAt(i));
            if (rotatedDigit == "-1")
                return false;
            sb.append(rotatedDigit);
        }
        return num.equals(sb.toString());
    }

    public String rotateDigit(char digit) {
        switch (digit) {
            case '0':
                return "0";
            case '1':
                return "1";
            case '6':
                return "9";
            case '8':
                return "8";
            case '9':
                return "6";
            default:
                return "-1";
        }
    }
}
