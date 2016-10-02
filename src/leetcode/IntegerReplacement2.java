package leetcode;

/*Given a positive integer n and you can do operations as follow:

If n is even, replace n with n/2.
If n is odd, you can replace n with either n + 1 or n - 1.
What is the minimum number of replacements needed for n to become 1?

Example 1:

Input:
8

Output:
3

Explanation:
8 -> 4 -> 2 -> 1
Example 2:

Input:
7

Output:
4

Explanation:
7 -> 8 -> 4 -> 2 -> 1
or
7 -> 6 -> 3 -> 2 -> 1
*/
//TLE
public class IntegerReplacement2 {
	public int integerReplacement(int n) {
		int end = 0;
		if (n % 2 != 0)
			end = n + 1;
		else
			end = n;
		int num[] = new int[end + 1];
		for (int i = 2; i <= end; i = i + 2) {
			num[i] = num[i / 2] + 1;
			if (i != 2)
				num[i - 1] = Math.min(num[i], num[i - 2]) + 1;
		}
		return num[n];
	}
}
