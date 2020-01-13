package company.alluxio;

/**
 * Given two strings A and B, the task is to convert A to B if possible.
 * The only operation allowed is to remove any character from A and insert it at A's front.
 * Find if it’s possible to convert the string. If yes, then output minimum noumber of operations required for transformation.
 *
 * For example, StringA=EABCD, StringB=AECBD
 * Minimum 3 operations:
 * CEABD
 * ECABD
 * AECBD
 */
public class MinimumOperation {
    public static int findMinimum(String A, String B) {
        if (A.length() != B.length()) {
            return -1;
        }
        int[] count = new int[26];
        for (char c : A.toCharArray()) {
            count[c - 'A']++;
        }
        for (char c : B.toCharArray()) {
            count[c - 'A']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return -1;
            }
        }

        int i = A.length() - 1;
        int j = B.length() - 1;
        int res = 0;
        while (i >= 0 && j >= 0) {
            if (A.charAt(i) == B.charAt(j)) {
                i--;
                j--;
            } else {
                i--;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findMinimum("EACBD", "EABCD"));
        System.out.println(findMinimum("CEABD", "EACBD"));
        System.out.println(findMinimum("IHGFCAETBD", "GHIFATECBD"));


    }
}
