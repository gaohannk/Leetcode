package leetcode;

import java.util.HashMap;

/**
 * Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = "ab", B = "ba"
 * Output: true
 * Example 2:
 * <p>
 * Input: A = "ab", B = "ab"
 * Output: false
 * Example 3:
 * <p>
 * Input: A = "aa", B = "aa"
 * Output: true
 * Example 4:
 * <p>
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * Example 5:
 * <p>
 * Input: A = "", B = "aa"
 * Output: false
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A and B consist only of lowercase letters.
 */
public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : A.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int diff = 0;
        for (int i = 0; i < B.length(); i++) {
            if (!map.containsKey(B.charAt(i))) {
                return false;
            }
            if (A.charAt(i) != B.charAt(i)) {
                diff++;
            }
        }
        return diff == 2 || (diff == 0 && map.keySet().stream().anyMatch(key -> map.get(key) > 1));
    }
}
