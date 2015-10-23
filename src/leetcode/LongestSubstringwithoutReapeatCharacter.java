package leetcode;
/* Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
/* brute force
 */
import java.util.Hashtable;

public class LongestSubstringwithoutReapeatCharacter {

	public int lengthOfLongestSubstring(String s) {
		char[] str = s.toCharArray();
		int max = 0;
		for (int i = 0; i < str.length; i++) {
			int count = 0;
			Hashtable<Character, Integer> hash = new Hashtable<Character, Integer>();
			for (int j = i; j < str.length; j++) {
				if (!hash.containsKey(str[j])) {
					hash.put(str[j], j);
				} else {
					count = hash.get(str[j]) - i + 1;
					break;
				}
			}
			if (count > max)
				max = count;
		}
		return max;
	}
}
