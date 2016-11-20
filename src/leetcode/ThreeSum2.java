package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/* Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 *     (-1, 0, 1)
 *     (-1, -1, 2)
 */
// Fix a, find b and c from head and end
public class ThreeSum2 {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(num.length<3)
			return res;
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			if (i == 0 || num[i] != num[i - 1]) {
				int start = i + 1;
				int end = num.length - 1;
				while (start < end) {
					if (num[start] + num[end] < -num[i])
						start++;
					else if (num[start] + num[end] > -num[i])
						end--;
					else {
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(num[i]);
						list.add(num[start]);
						list.add(num[end]);
						res.add(list);
						start++;
						end--;
						while (start < end && num[end] == num[end + 1])
							end--;
						while (start < end && num[start] == num[start - 1])
							start++;
					}
				}
			}
		}
		return res;
	}
}
