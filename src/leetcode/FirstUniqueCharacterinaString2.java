package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/*Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
*/
public class FirstUniqueCharacterinaString2 {
	public int firstUniqChar(String s) {
		if (s == null)
			return -1;
		if (s.length() == 1)
			return 0;
		HashSet<Character> set = new HashSet<>();
		HashSet<Character> set2 = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (!set.contains(s.charAt(i))) {
				set.add(s.charAt(i));
			} else {
				set2.add(s.charAt(i));
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (!set2.contains(s.charAt(i)))
				return i;
		}
		return -1;
	}
}
