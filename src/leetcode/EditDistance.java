package leetcode;

/* Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
/* DP: dp[i][j] means the min steps to tranform word1[0~i] into word2[0~j](exclusive)
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
		int[][] dis = new int[word1.length() + 1][word2.length() + 1];
		// initialize
		for (int i = 0; i <= word1.length(); i++) 
			dis[i][0] = i;
	
		for (int i = 0; i <= word2.length(); i++) 
			dis[0][i] = i;
		
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				int min = dis[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
				min = Math.min(dis[i - 1][j] + 1, min);
				min = Math.min(dis[i][j - 1] + 1, min);
				dis[i][j] = min;
			}
		}

		return dis[word1.length()][word2.length()];

	}
}
