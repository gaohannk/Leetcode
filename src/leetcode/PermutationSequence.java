package leetcode;

/* The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 */
import java.util.Arrays;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
		int[] num = new int[n];
		for (int i = 0; i < n; i++)
			num[i] = i + 1;
		while (--k > 0)
			nextPermutation(num);
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < n; i++)
			str.append(num[i]);
		return str.toString();
	}

	public void nextPermutation(int[] num) {
		if (num.length <= 1)
			return;
		for (int i = num.length - 2; i >= 0; i--) {
			if (num[i] < num[i + 1]) {
				int j;
				for (j = num.length - 1; j >= i; j--)
					if (num[i] < num[j])
						break;
				int temp = num[i];
				num[i] = num[j];
				num[j] = temp;
				Arrays.sort(num, i + 1, num.length);
				return;
			}
		}
	}
}
