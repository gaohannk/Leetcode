package leetcode;

/**
 * Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.
 * <p>
 * Return true if and only if we can do this in a way such that the resulting number is a power of 2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: true
 * Example 2:
 * <p>
 * Input: 10
 * Output: false
 * Example 3:
 * <p>
 * Input: 16
 * Output: true
 * Example 4:
 * <p>
 * Input: 24
 * Output: false
 * Example 5:
 * <p>
 * Input: 46
 * Output: true
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 10^9
 */
public class ReorderedPowerofTwo {
    public static boolean reorderedPowerOf2(int N) {
        int[] digits = buildDigits(N);
        return nextPermuatation(digits, 0);
    }

    public static int[] buildDigits(int N) {
        String str = Integer.toString(N);
        int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
        }
        return digits;
    }

    /**
     * Returns true if some permutation of (A[start], A[start+1], ...)
     * can result in A representing a power of 2.
     */
    private static boolean nextPermuatation(int[] digits, int start) {
        if (start == digits.length)
            return isPowerOf2(digits);
        for (int i = start; i < digits.length; i++) {
            // Place A[start] with value A[i].
            swap(digits, start, i);
            // For each such placement of A[start], if a permutation
            // of (A[start+1], A[start+2], ...) can result in A
            // representing a power of 2, return true.
            if (nextPermuatation(digits, start + 1))
                return true;

            // Restore the array to the state it was in before
            // A[start] was placed with value A[i].
            swap(digits, start, i);
        }
        return false;
    }

    private static boolean isPowerOf2(int[] digits) {
        if (digits[0] == 0)
            return false;
        int num = buildNumber(digits);
        // check if only one bit is 1
        while (num > 0 && (num & 1) == 0) {
            num >>= 1;
        }

        // Check that there are no other factors besides 2
        return num == 1;
    }

    private static int buildNumber(int[] digits) {
        String str = "";
        for (int i = 0; i < digits.length; i++) {
            str = str + digits[i];
        }
        return Integer.valueOf(str);
    }

    public static void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    public static void main(String[] args) {
        System.out.print(reorderedPowerOf2(214806876));
    }
}
