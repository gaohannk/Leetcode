package leetcode;
/* Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
import java.util.HashMap;

public class LongestSubstringwithoutReapeatCharacter3 {
	public static int lengthOfLongestSubstring(String s) {
		char[] arr = s.toCharArray();
		int pre = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], i);
			} else {
				pre = pre > map.size() ? pre : map.size();
				i = map.get(arr[i]);
				map.clear();
			}
		}
		return Math.max(pre, map.size());
	}
}
