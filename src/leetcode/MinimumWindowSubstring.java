package leetcode;

import java.util.HashMap;

/* Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
/* 建立一个字典，然后维护一个窗口。遇到没在字典里面的字符可以继续移动窗口右端，而移动窗口左端的条件是当找到满足条件的串之后，
 * 一直移动窗口左端直到有字典里的字符不再在窗口里。在实现中维护一个HashMap，一开始key包含字典中所有字符，value就是该字符的数量，
 * 然后遇到字典中字符时就将对应字符的数量减一。算法的时间复杂度是O(n),其中n是字符串的长度，因为每个字符再维护窗口的过程中不会被访问多于两次。空间复杂度则是O(字典的大小)，也就是代码中T的长度。
 * 
 */
public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		if (S == null || T == null || S.length() == 0 || T.length() == 0)
			return "";
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < T.length(); i++) {
			if (map.containsKey(T.charAt(i))) {
				map.put(T.charAt(i), map.get(T.charAt(i)) + 1);
			} else
				map.put(T.charAt(i), 1);
		}
		int count = 0;
		int pre = 0;
		String res = "";
		int minLen = S.length() + 1;
		for (int i = 0; i < S.length(); i++) {
			if (map.containsKey(S.charAt(i))) {
				map.put(S.charAt(i), map.get(S.charAt(i)) - 1);
				if (map.get(S.charAt(i)) >= 0)
					count++;
				while (count == T.length()) {
					if (map.containsKey(S.charAt(pre))) {
						map.put(S.charAt(pre), map.get(S.charAt(pre)) + 1);
						if (map.get(S.charAt(pre)) > 0) {
							if (minLen > i - pre + 1) {
								res = S.substring(pre, i + 1);
								minLen = i - pre + 1;
							}
							count--;
						}
					}
					pre++;
				}
			}
		}
		return res;
	}
}
