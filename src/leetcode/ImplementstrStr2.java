package leetcode;

/* Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
/* 线性算法rolling hash，可以参见Rolling hash - Wikipedia。
 * 基本思想是用一个hashcode来表示一个字符串，为了保证hash的唯一性，用比字符集大的素数为底，以这个素数的幂为基。
 * 举例来说，字符集是小写字母集，取素数29为底。比如字符串“abacd”,转化为hashcode=1+2*29+1*29^2+3*29^3+4*29^4。
 * 然后是如何在前进一步的时候计算新的hashcode，比如匹配串是原串是“abacde”，匹配串长度为5，根据以上的方法计算”abacd“的hashcode=h，
 * 那么下一步“bacde”的hashcode=h/29+5*29^4。这是一个constant的操作，所以检测所有子串的时间复杂度只需要O(m+n-m)=O(n)，也是一个线性算法。
 * 这个方法的hashcode比较容易越界，因为以素数为底的幂会很大，解决的办法可以用BigInteger,
 * 或者如同Rabin–Karp algorithm - Wikipedia一样对于hashcode进行取余，但是可能存在多个字符串映射到同一hashcode的问题，尽管是很少数的情况。
 */
public class ImplementstrStr2 {
	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null)
			return -1;
		if (needle.length() > haystack.length())
			return -1;

		int base = 29;
		long patternHash = 0;
		long tempBase = 1;
		long hayHash = 0;

		for (int i = needle.length() - 1; i >= 0; i--) {
			patternHash += (int) needle.charAt(i) * tempBase;
			tempBase *= base;
		}
		tempBase = 1;
		for (int i = needle.length() - 1; i >= 0; i--) {
			hayHash += (int) haystack.charAt(i) * tempBase;
			tempBase *= base;
		}
		tempBase /= base;

		if (hayHash == patternHash) {
			return 0;
		}

		for (int i = needle.length(); i < haystack.length(); i++) {
			hayHash = (hayHash - (int) haystack.charAt(i - needle.length()) * tempBase) * base
					+ (int) haystack.charAt(i);
			if (hayHash == patternHash)
				return i - needle.length() + 1;
		}
		return -1;
	}
}
