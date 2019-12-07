package leetcode.algo.c;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string s, we make queries on substrings of s.
 * <p>
 * For each query queries[i] = [left, right, k], we may rearrange the substring s[left], ..., s[right], and then choose up to k of them to replace with any lowercase English letter.
 * <p>
 * If the substring is possible to be a palindrome string after the operations above, the result of the query is true. Otherwise, the result is false.
 * <p>
 * Return an array answer[], where answer[i] is the result of the i-th query queries[i].
 * <p>
 * Note that: Each letter is counted individually for replacement so if for example s[left..right] = "aaa", and k = 2, we can only replace two of the letters.  (Also, note that the initial string s is never modified by any query.)
 * <p>
 * <p>
 * <p>
 * Example :
 * <p>
 * Input: s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
 * Output: [true,false,false,true,true]
 * Explanation:
 * queries[0] : substring = "d", is palidrome.
 * queries[1] : substring = "bc", is not palidrome.
 * queries[2] : substring = "abcd", is not palidrome after replacing only 1 character.
 * queries[3] : substring = "abcd", could be changed to "abba" which is palidrome. Also this can be changed to "baab" first rearrange it "bacd" then replace "cd" with "ab".
 * queries[4] : substring = "abcda", could be changed to "abcba" which is palidrome.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, queries.length <= 10^5
 * 0 <= queries[i][0] <= queries[i][1] < s.length
 * 0 <= queries[i][2] <= s.length
 * s only contains lowercase English letters.
 */
//TLE
public class CanMakePalindromefromSubstring {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new LinkedList<>();
        List<int[]> freqList = new LinkedList<>(); // length: s.length+1
        int[] freq = new int[26];
        freqList.add(freq);
        for (int i = 0; i < s.length(); i++) {
            // Copy array
            int[] f = Arrays.copyOf(freqList.get(i), 26);
            f[s.charAt(i) - 'a']++;
            freqList.add(f);
        }

        for (int[] q : queries) {
            int[] f1 = freqList.get(q[0]);
            int[] f2 = freqList.get(q[1] + 1);
            int countOdd = 0;
            for (int i = 0; i < 26; i++) {
                if ((f2[i] - f1[i]) % 2 != 0) {
                    countOdd++;
                }
            }
            if (q[2] > 13) {
                res.add(true);
                continue;
            }
            res.add(countOdd / 2 <= q[2]);
        }
        return res;
    }
}
