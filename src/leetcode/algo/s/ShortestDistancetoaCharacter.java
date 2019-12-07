package leetcode.algo.s;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * <p>
 * <p>
 * Note:
 * <p>
 * S string length is in [1, 10000].
 * C is a single character, and guaranteed to be in string S.
 * All letters in S and C are lowercase.
 */
public class ShortestDistancetoaCharacter {
    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];
        List<Integer> idx = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C)
                idx.add(i);
        }
        for (int i = 0; i < S.length(); i++) {
            int last = 0;
            for (int cur : idx) {
                // Edge case
                if (i < idx.get(0)) {
                    res[i] = idx.get(0) - i;
                    break;
                }
                // Edge case
                if (i > idx.get(idx.size() - 1)) {
                    res[i] = i - idx.get(idx.size() - 1);
                    break;
                }
                // Compare left and right distance
                if (i > last && i < cur) {
                    res[i] = Math.min(i - last, cur - i);
                    break;
                } else
                    last = cur;
            }
        }
        return res;
    }
}
