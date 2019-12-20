package leetcode.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * A decimal number can be converted to its Hexspeak representation by first converting it to an uppercase hexadecimal string, then replacing all occurrences of the digit 0 with the letter O, and the digit 1 with the letter I.  Such a representation is valid if and only if it consists only of the letters in the set {"A", "B", "C", "D", "E", "F", "I", "O"}.
 *
 * Given a string num representing a decimal integer N, return the Hexspeak representation of N if it is valid, otherwise return "ERROR".
 *
 * Example 1:
 *
 * Input: num = "257"
 * Output: "IOI"
 * Explanation:  257 is 101 in hexadecimal.
 * Example 2:
 *
 * Input: num = "3"
 * Output: "ERROR"
 * Constraints:
 *
 * 1 <= N <= 10^12
 * There are no leading zeros in the given string.
 * All answers must be in uppercase letters.
 */
public class Hexspeak {

    public String toHexspeak(String num) {

        long n = Long.parseLong(num);
        HashMap<Integer, Character> map = new HashMap<>();
        map.put(0, 'O');
        map.put(1, 'I');
        map.put(10, 'A');
        map.put(11, 'B');
        map.put(12, 'C');
        map.put(13, 'D');
        map.put(14, 'E');
        map.put(15, 'F');

        String ans = "";

        while(n > 0){
            int rem = (int)(n % 16);
            if(rem > 1 && rem < 10) return "ERROR";
            n = n / 16;
            ans = map.get(rem) + ans;
        }

        return ans;

    }
}
