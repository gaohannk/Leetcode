package leetcode;
/* Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringwithoutReapeatCharacter2 {
	public int lengthOfLongestSubstring(String s) {
		int[] occ = new int[256];
		int max = 0, counter = 0, start = 1;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (occ[ch] >= start) {
				counter -= occ[ch] - start + 1;
				start = occ[ch] + 1;
			}
			occ[ch] = i + 1;
			max = Math.max(max, ++counter);
		}
		return max;
	}
}
