package leetcode;

import java.util.ArrayList;

/* The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
/* 镜射排列
 * n位元的格雷码可以从n-1位元的格雷码以上下镜射后加上新位元的方式快速的得到
 */
public class GrayCode2 {
	public class Solution {
	    public ArrayList<Integer> grayCode(int n) {
	        if(n==0) {
	            ArrayList<Integer> result = new ArrayList<Integer>();
	            result.add(0);
	            return result;
	        }
	        
	        ArrayList<Integer> tmp = grayCode(n-1);
	        int addNumber = 1 << (n-1);
	        ArrayList<Integer> result = new ArrayList<Integer>(tmp);
	        for(int i=tmp.size()-1;i>=0;i--) {
	            result.add(addNumber + tmp.get(i));
	        }
	        return result;
	    }
	}
}
