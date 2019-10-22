package leetcode.algo.r;

/*Given an array of integers A and let n to be its length.

Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:

F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].

Calculate the maximum value of F(0), F(1), ..., F(n-1).

Note:
n is guaranteed to be less than 105.

Example:

A = [4, 3, 2, 6]

F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
*/
//TLE O(n^2)
/*
 * public int maxRotateFunction(int[] A) {
		if (A.length == 0 || A == null)
			return 0;
		int max = Integer.MIN_VALUE;
		int F[] = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			for (int j = i; j < A.length + i; j++) {
				F[j % A.length] = (j % A.length) * A[i];
			}
		}
		for (int i = 0; i < A.length; i++) {
			max = max > F[i] ? max : F[i];
		}
		return max;
	}
 */
public class RotateFunction {
	public int maxRotateFunction(int[] A) {
		if(A.length==0 ||A==null)
			return 0;
		
		int start = A.length;
		int max = Integer.MIN_VALUE;
		int rotate = A.length;
		while (rotate-- > 0) {
			int sum = 0;
			int index = start;
			for (int i = 0; i < A.length; i++) {
				sum += i * A[index % A.length];
			}
			start--;
			if (sum > max)
				max = sum;
		}
		return max;
	}
	
}
