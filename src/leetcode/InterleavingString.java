package leetcode;

/* Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */
/* 二维动态规划问题：
 * 定义布尔型数组match[i][j]表示s1(0,i-1)和s2(0,j-1)满足交替形成s3(0,i+j-1),有如下转移方程：
 * i>=1,j>=11
 * match[i][j]= s1(i-1)==s3(i+j-1)&&match[i-1][j]||s2(j-1)==s3(i+j-1)&&match[i][j-1]
 * 其中s1(i)表示index为i的字符。
 * 初始条件：
 * match[0][0]=true;
 * match[0][j]=s2(j-1)==s3(j-1)&&match[0][j-1]
 * match[i][0]=s1(i-1)==s3(i-1)&&match[i-1][0]
 */
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
		if (s1 == null || s2 == null || s3 == null)
			return false;
		
		if (len1 + len2 != len3)
			return false;
		boolean[][] match = new boolean[len1 + 1][len2 + 1];
		match[0][0] = true;
		for (int i = 1; i <= len1; i++) {
			match[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && match[i - 1][0];
		}
		
		for (int j = 1; j <= len2; j++) {
			match[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1) && match[0][j - 1];
		}
		
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && match[i - 1][j])
					match[i][j] = true;
				if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && match[i][j - 1])
					match[i][j] = true;
			}
		}
		return match[len1][len2];
	}
}
