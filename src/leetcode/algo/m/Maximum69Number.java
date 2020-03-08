package leetcode.algo.m;

/**
 * Given a positive integer num consisting only of digits 6 and 9.
 *
 * Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 *
 *
 *
 * Example 1:
 *
 * Input: num = 9669
 * Output: 9969
 * Explanation:
 * Changing the first digit results in 6669.
 * Changing the second digit results in 9969.
 * Changing the third digit results in 9699.
 * Changing the fourth digit results in 9666.
 * The maximum number is 9969.
 * Example 2:
 *
 * Input: num = 9996
 * Output: 9999
 * Explanation: Changing the last digit 6 to 9 results in the maximum number.
 * Example 3:
 *
 * Input: num = 9999
 * Output: 9999
 * Explanation: It is better not to apply any change.
 *
 */
public class Maximum69Number {
    public int maximum69Number(int num) {
        String number = String.valueOf(num);
        String res = "";
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '6') {
                res = number.substring(0, i) + "9" + number.substring(i + 1);
                break;
            }
        }
        return res == "" ? num : Integer.parseInt(res);
    }

    public int maximum69Number2(int num) {
        char[] number = String.valueOf(num).toCharArray();
        for (int i = 0; i < number.length; i++) {
            if (number[i] == '6') {
                number[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(number));
    }
}
