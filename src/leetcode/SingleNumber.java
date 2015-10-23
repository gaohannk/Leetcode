package leetcode;

/* Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {
	public int singleNumber(int[] A) {
		int len = A.length;
		if (len == 0)
			return 0;
		int record = A[0];
		for (int i = 1; i < len; i++) 
			record = record ^ A[i];
		return record;
	}
}
