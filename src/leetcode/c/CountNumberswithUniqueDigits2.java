package leetcode.c;

/*Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])

Show Hint 
1. A direct way is to use the backtracking approach.
2. Backtracking should contains three states which are (the current number, number of steps to get that number and a bitmask which represent which number is marked as visited so far in the current number). Start with state (0,0,0) and count all valid number till we reach number of steps equals to 10n.
3. This problem can also be solved using a dynamic programming approach and some knowledge of combinatorics.
4. Let f(k) = count of numbers with unique digits with length equals k.
5. f(1) = 10, ..., f(k) = 9 * 9 * 8 * ... (9 - k + 2) [The first factor is 9 because a number cannot start with 0
*/
/* dp[1]=10
 * dp[2]=dp[1]+(9)*9
 * dp[3]=dp[2]+(8*9)*9
 * dp[n]= d[n-1] + (11-n)*..*9
 */
public class CountNumberswithUniqueDigits2 {
	public static int countNumbersWithUniqueDigits(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 10;
		int last = 10;
		int sum = 9;
		for (int k = 2; k <= n; k++) {
			sum *= (11 - k);
			last = last + sum;
		}
		return last;
	}

	public static void main(String[] args) {
		System.out.println(countNumbersWithUniqueDigits(9));
	}
}
