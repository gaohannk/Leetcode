package leetcode;

import java.util.HashMap;

/*Given a string you need to print longest possible substring that has exactly M unique characters.
If there are more than one substring of longest possible length, then print any one of them.
 * 
 */
public class LongestSubstringwithAtMostKDistinctCharacters {
    public static String lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s == null)
            return "";
        if (s.length() < k)
            return s;
        HashMap<Character, Integer> map = new HashMap<>();

        int maxLen = k;
        int left = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (map.size() > k) {
                res = res.length() > i - left ? res : s.substring(left, i);
                maxLen = Math.max(maxLen, i - left);
                while (map.size() > k) {
                    char fc = s.charAt(left);
                    if (map.get(fc) == 1)
                        map.remove(fc);
                    else
                        map.put(fc, map.get(fc) - 1);
                    left++;
                }
            }
        }
        res = res.length() > s.length() - left ? res : s.substring(left, s.length());
        maxLen = Math.max(maxLen, s.length() - left);
        return res;
    }

    public static void main(String[] args) {
        String s = "abccccccccaaddddeeee";
        int k = 3;
        System.out.println(lengthOfLongestSubstringKDistinct(s, k));
    }
}
