package leetcode.c;

import java.util.ArrayList;
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

public class CanMakePalindromefromSubstring2 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList<Boolean>();

        //use a 2D array to record total number of ['a'-'z'] character in substring(0,n)
        int[][] dp = new int[s.length() + 1][26];

        //base case
        for (int i = 0; i < 26; i++) {
            dp[0][i] = 0;
        }

        //record frequency map in substring(0,i-1)
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            char c = s.charAt(i - 1);
            dp[i][c - 'a'] += 1;
        }

        //execute the queries
        for (int[] q : queries) {
            //because the corresponding string index in our 2D array starts at 1, so add 1 to left and right index
            int left = q[0] + 1;
            int right = q[1] + 1;
            int k = q[2];

            //if k is large than 13, means we can change any substring to a palindrome
            if (k >= 13) {
                result.add(true);
                continue;
            }
            //else read from the 2D array to see how many extra characters are within substring [left, right] inclusive
            //if the number of extra characters/2 are less than k, add true
            int oddCount = 0;
            for (int i = 0; i < 26; i++) {
                oddCount += (dp[right][i] - dp[left - 1][i]) % 2;
            }
            result.add(oddCount / 2 <= k);
        }
        return result;
    }
}
