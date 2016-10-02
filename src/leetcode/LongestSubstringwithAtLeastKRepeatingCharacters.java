package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
*/
public class LongestSubstringwithAtLeastKRepeatingCharacters {
	public int longestSubstring(String s, int k) {
		if (s.length() == 0 || s.length() < k)
			return 0;
		char[] chars = s.toCharArray();
		int[] counts = new int[26];
		for (char c : chars) {
			counts[c - 'a']++;
		}
		int count = 0;
		List<Integer> index = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (counts[ch - 'a'] < k) {
				index.add(i);
				count++;
			}
		}
		if (count == 0)
			return s.length();
		String[] subString = new String[count + 1];
		subString[0] = s.substring(0, index.get(0));
		for (int i = 1; i < count; i++) {
			subString[i] = s.substring(index.get(i - 1) + 1, index.get(i));
		}
		subString[count] = s.substring(index.get(count - 1) + 1);

		int max = 0;
		for (int i = 0; i <= count; i++) {
			if (subString[i].length() == 0)
				continue;
			int len = longestSubstring(subString[i], k);
			max = len > max ? len : max;
		}
		return max;
	}
}
