package leetcode;
/* Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * Note: you may assume that n is not less than 2.
 * Hint:
 * There is a simple O(n) solution to this problem.
 * You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
 * */
// greedy solution
public class IntegerBreak {
	public int integerBreak(int n) {
		if(n==2)
			return 1;
		if(n==3)
			return 2;
		if(n%3==0)
			return (int) Math.pow(3, n/3);
		if(n%3==1)
			return (int) Math.pow(3, n/3-1)*4;
		if(n%3==2)
			return (int) (Math.pow(3, n/3)*2);
		return n;
	}
}
