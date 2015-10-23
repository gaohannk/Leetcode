package leetcode;

/* Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
/* brute force的算法，假设原串的长度是n，匹配串的长度是m。
 * 对原串的每一个长度为m的字串都判断是否跟匹配串一致.总共有n-m+1个子串，所以算法时间复杂度为O((n-m+1)*m)=O(n*m)，空间复杂度是O(1)。
 */
public class ImplementstrStr {

	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null)
			return -1;
		if (needle.length() > haystack.length())
			return -1;
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			boolean successFlag = true;
			for (int j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					successFlag = false;
					break;
				}
			}
			if (successFlag)
				return i;
		}
		return -1;
	}
}
