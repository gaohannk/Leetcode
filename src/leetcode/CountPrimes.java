package leetcode;

import java.util.Arrays;

/* Description:
 * Count the number of prime numbers less than a non-negative number, n
 */
public class CountPrimes {
	public int countPrimes(int n) {
		boolean[] flag = new boolean[n];
		Arrays.fill(flag, true);
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (flag[i]) {
				for (int j = 2 * i; j < n; j += i)
					flag[j] = false;
			}
		}
		int count = 0;
		for (int i = 2; i < n; i++)
			count = flag[i] == true ? count + 1 : count;
		return count;
	}
}
