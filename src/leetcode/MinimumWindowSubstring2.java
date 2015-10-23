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
public class MinimumWindowSubstring2 {
	public String minWindow(String S, String T) {
		if (S == null || T == null)
			return null;
		if (S.length() == 0 || T.length() == 0 || S.length() < T.length())
			return "";
		HashMap<Character, Integer> needFind = new HashMap<Character, Integer>();
		HashMap<Character, Integer> alreadyFind = new HashMap<Character, Integer>();

		for (int i = 0; i < T.length(); i++) {
			alreadyFind.put(T.charAt(i), 0);
			if (needFind.containsKey(T.charAt(i))) {
				needFind.put(T.charAt(i), needFind.get(T.charAt(i)) + 1);
			} else {
				needFind.put(T.charAt(i), 1);
			}
		}
		int minStart = -1;
		int minEnd = S.length();
		int start = 0;
		int len = 0;
		for (int i = 0; i < S.length(); i++) {
			if (alreadyFind.containsKey(S.charAt(i))) {
				alreadyFind.put(S.charAt(i), alreadyFind.get(S.charAt(i)) + 1);

				if (alreadyFind.get(S.charAt(i)) <= needFind.get(S.charAt(i)))
					len++;

				if (len == T.length()) {
					while (!needFind.containsKey(S.charAt(start))
							|| alreadyFind.get(S.charAt(start)) > needFind.get(S.charAt(start))) {
						if (needFind.containsKey(S.charAt(start)))
							alreadyFind.put(S.charAt(start), alreadyFind.get(S.charAt(start)) - 1);
						start++;
					}
					if (i - start < minEnd - minStart) {
						minStart = start;
						minEnd = i;
					}

				}
			}

		}
		if (minStart == -1) {
			return "";
		}
		return S.substring(minStart, minEnd + 1);
	}
}
