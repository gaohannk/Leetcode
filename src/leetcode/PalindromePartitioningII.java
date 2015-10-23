package leetcode;

/* Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
/* 定义状态数组：cut_num[s.length()+1]，其中：cut_num[i]代表：string[i..n]字符串从i开始到末尾的最小划分数。 
 * 状态转移方程：cut_num[i] = Math.min(cut_num[i], cut_num[j+1]+1);i<j<n, string[i..j]是一个回文字符串，所以不用再划分。
 * 所以从i开始到末尾以j为划分点的最小划分数为: cut_num[j+1]+1 和 cut_num[i]中的最小值。
 * cut_num[i]的初值设为：s.length() - i; 也就是按照字符串中的每个字母都单独被划分来计算。
 */
public class PalindromePartitioningII {
	public class Solution {
		public int minCut(String s) {
			if (s == null || s.length() == 0 || s.length() == 1) {
				return 0;
			}
			int[][] palindrome = new int[s.length()][s.length()];
			int[] cut_num = new int[s.length() + 1];

			for (int i = s.length() - 1; i >= 0; i--) {
				cut_num[i] = s.length() - i;
				for (int j = i; j < s.length(); j++) {
					if (s.charAt(i) == s.charAt(j)) {
						if (j - i < 2 || palindrome[i + 1][j - 1] == 1) {
							palindrome[i][j] = 1;
							cut_num[i] = Math.min(cut_num[i], cut_num[j + 1] + 1);
						}
					}
				}
			}
			return cut_num[0] - 1;
		}
	}
}
