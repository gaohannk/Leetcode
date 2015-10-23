package leetcode;

/* A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */
public class FindPeakElement {
	public int findPeakElement(int[] num) {
		if (num.length == 1)
			return 0;
		for (int i = 0; i < num.length; i++) {
			if (i == 0 && num[i] > num[i + 1])
				return i;
			else if (i == num.length-1 && num[i] > num[i - 1])
				return i;
			else if (i != 0 && i != num.length-1 && num[i] > num[i + 1] && num[i] > num[i - 1])
				return i;
		}
		return -1;
	}
}
