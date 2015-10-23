package leetcode;

import java.util.Arrays;

/* Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, 
 * and the other N − h papers have no more than h citations each."
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total 
 * and each of them had received 3, 0, 6, 1, 5 citations respectively. 
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 */
/* Hint:
 * An easy approach is to sort the array first.
 * What are the possible values of h-index?
 * A faster approach is to use extra space.
 */
public class HIndex {
	public static int hIndex(int[] citations) {
		Arrays.sort(citations);
		if (citations.length == 0)
			return 0;
		if (citations.length == 1)
			return citations[0] >= 1 ? 1 : 0;
		int h = 1;
		for (int i = citations.length - 1; i >= 0; i--) {
			if (h > citations[i])
				return h - 1;
			h++;
		}
		return h-1;
	}

	public static void main(String[] args) {
		int[] a = { 1,12,15 };
		System.out.println(hIndex(a));
	}
}
