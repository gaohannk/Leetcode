package leetcode;
/* Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
/* TLE: brute force
 */

import java.util.HashMap;

public class LongestSubstringwithoutReapeatCharacter {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        char[] str = s.toCharArray();
        int max = 0;
        for (int i = 0; i < str.length; i++) {
            int count = 0;
            HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
            int j = 0;
            for (j = i; j < str.length; j++) {
                if (!hash.containsKey(str[j])) {
                    hash.put(str[j], j);
                } else {
                    count = j - i;
                    break;
                }
            }
            if (j == str.length)
                count = str.length - i;
            if (count > max)
                max = count;
        }
        return max == 0 ? 1 : max;
    }

    public static void main(String[] args) {
        String s = "cdd";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
