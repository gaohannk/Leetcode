package leetcode.algo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s and an integer k, return the length of the longest substring of s that contains
 * at most k distinct characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "eceba", k = 2 Output: 3 Explanation: The substring is "ece" with length 3. Example
 * 2:
 *
 * Input: s = "aa", k = 1 Output: 2 Explanation: The substring is "aa" with length 2.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104 0 <= k <= 50
 */

public class LongestSubstringwithAtMostKDistinctCharacters {

  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int n = s.length();
    if (n * k == 0) {
      return 0;
    }
    int left = 0;
    int right = 0;

    Map<Character, Integer> rightmostPosition = new HashMap<>();

    int maxLength = 1;

    while (right < n) {
      rightmostPosition.put(s.charAt(right), right++);

      if (rightmostPosition.size() == k + 1) {
        int lowestIndex = Collections.min(rightmostPosition.values());
        rightmostPosition.remove(s.charAt(lowestIndex));
        left = lowestIndex + 1;
      }

      maxLength = Math.max(maxLength, right - left);
    }
    return maxLength;
  }
}
