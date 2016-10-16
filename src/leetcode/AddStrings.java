package leetcode;

/**
 * Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.
 * Note:
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class AddStrings {
    public static String addStrings(String num1, String num2) {
        String res = "";
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int advance = 0;
        while (i >= 0 && j >= 0) {
            int digit = num1.charAt(i) - '0' + num2.charAt(j) - '0' + advance;
            if (digit >= 10) {
                digit %= 10;
                advance = 1;
            } else {
                advance = 0;
            }
            // System.out.println(res);
            res = digit + res;
            i--;
            j--;
        }
        if (i >= 0) {
            res = (char) (num1.charAt(i) - '0' + advance) + res;
            res = num1.substring(0, i) + res;
        } else if (j >= 0) {
            res = (char) (num2.charAt(j) - '0' + advance) + res;
            res = num2.substring(0, j) + res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(addStrings("123", "4566"));
    }

}
