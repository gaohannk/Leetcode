package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class ReverseVowelsofaString2 {
	public static String reverseVowels(String s) {
		if (s == null)
			return "";
		char chars[] = s.toCharArray();
		int i = 0, j = s.length() - 1;
		while (i <= j) {
			while (i < s.length() - 1 && !isvowel(s.charAt(i)))
				i++;
			while (j >= 0 && !isvowel(s.charAt(j)))
				j--;
			if (i < s.length() && j >= 0) {
				chars[i] = s.charAt(j);
				chars[j] = s.charAt(i);
				i++;
				j--;
			}
		}
		return new String(chars);
	}

	private static boolean isvowel(char c) {
		int pos = "aeiouAEIOU".indexOf(c);
		return pos >= 0;
	}
}
