package leetcode;

import java.math.BigInteger;

/* Additive number is a positive integer whose digits can form additive sequence.
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 * For example:
 * "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * Given a string represents an integer, write a function to determine if it's an additive number.
 * Follow up:
 * How would you handle overflow for very large input integers?
 */
public class AdditiveNumber {
    public static boolean isAdditiveNumber(String num) {
        long digit = num.length();
        for (int i = 1; i <= digit; i++) {
            // Leading "0" like "011" true, "0123" false, "0112" true
            if (num.startsWith("0") && i != 1)
                break;
            BigInteger one = new BigInteger(num.substring(0, i));
            for (int j = i + 1; j <= digit; j++) {
                // Leading "0" like "101" true, "1023" false, "1022" true
                if (num.substring(i).startsWith("0") && j != i + 1)
                    break;
                BigInteger two = new BigInteger(num.substring(i, j));
                if (isAdditiveNumberHelper(num.substring(j), one, two))
                    return true;
            }
        }
        return false;
    }

    private static boolean isAdditiveNumberHelper(String num, BigInteger one, BigInteger two) {
        int digit = num.length();
        for (int k = 1; k <= digit; k++) {
            // Leading "0" for third number
            if (num.startsWith("0") && k != 1)
                break;
            BigInteger three = new BigInteger(num.substring(0, k));
            if (one.add(two).equals(three)) {
                // End of string
                if (num.substring(k).length() == 0)
                    return true;
                return isAdditiveNumberHelper(num.substring(k), two, three);
            }
            // Prune e.g. "1121345" 1 + 12 < 13, 134, 1345
            if (one.add(two).compareTo(three) == -1)
                break;
        }
        // No third number
        return false;
    }

    public static void main(String[] args) {
        isAdditiveNumber("211738");
    }

}
