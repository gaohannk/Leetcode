package leetcode;

import java.util.Arrays;

/* Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * Note: You may assume the string contains only lowercase alphabets.
 */
public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		char[] sarray = s.toCharArray();
		char[] tarray = t.toCharArray();
		Arrays.sort(sarray);
		Arrays.sort(tarray);
		for (int i = 0; i < sarray.length; i++) {
			if (sarray[i] != tarray[i])
				return false;
		}
		return true;
	}
}
