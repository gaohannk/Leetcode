package leetcode;

/* Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		int minlength = Integer.MAX_VALUE;
		String prefix = "";
		if (strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];
		for (int i = 0; i <= strs.length - 1; i++) {
			if (minlength > strs[i].length())
				minlength = strs[i].length();
		}
		for (int index = 0; index <= minlength - 1; index++) {
			char ch = strs[0].charAt(index);
			for (String str : strs) {
				if (ch != str.charAt(index))
					return prefix;
			}
			prefix += ch;
		}
		return prefix;
	}
}
