package leetcode;
/* Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 */
/* Because all trailing 0 is from factors 5 * 2.
 * But sometimes one number may have several 5 factors, for example, 25 have two 5 factors, 125 have three 5 factors. 
 * In the n! operation, factors 2 is always ample. So we just count how many 5 factors in all number from 1 to n.
 */
public class FactorialTrailingZeroes {
	  public int trailingZeroes(int n) {
	        int count=0;
	        int div=5;
	        while(n>0){
	            count+=n/div;
	            n/=div;
	        }
	        return count;
	    }
}
