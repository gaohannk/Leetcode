package leetcode;

import java.util.HashMap;
import java.util.Map;

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
public class StrobogrammaticNumber3 {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');

        int i = 0;
        int j = num.length() - 1;

        while (i <= j) {
            char left = num.charAt(i);
            char right = num.charAt(j);
            if (!map.containsKey(left) || !map.containsKey(right) || map.get(left) != right) {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }
}
