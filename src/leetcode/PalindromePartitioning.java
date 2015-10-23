package leetcode;

import java.util.ArrayList;

/* Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return
 * [
 *  ["aa","b"],
 *  ["a","a","b"
 * ]
 */
/* 取出前面下标从0开始到i-1结束的子串substr(0,i)，判断是否满足回文字符串的要求，
 * 如果满足要求递归调用求substr(i+1,len)子问题。
 */
public class PalindromePartitioning {
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (s == null || s.length() == 0)
			return result;

		ArrayList<String> partition = new ArrayList<String>();
		addPalindrome(s, 0, partition, result);
		return result;
	}

	private void addPalindrome(String s, int start, ArrayList<String> partition, ArrayList<ArrayList<String>> result) {
		if (start == s.length()) {
			result.add(new ArrayList<String>(partition));
			return;
		}

		for (int i = start + 1; i <= s.length(); i++) {
			String str = s.substring(start, i);
			if (isPalindrome(str)) {
				partition.add(str);
				addPalindrome(s, i, partition, result);
				partition.remove(partition.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;

		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
