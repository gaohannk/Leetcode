package leetcode;

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
import java.util.*;
//TLE
public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
	
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(num.length<3)
			return res;
		for (int i = 0; i < num.length; i++) {
			for (int j = i; j < num.length; j++) {
				for (int k = j; k < num.length; k++) {
					if (num[i] + num[j] + num[k] == 0) {
						int[] arr = new int[] { num[i], num[j], num[k] };
						Arrays.sort(arr);
						for (int m = 0; m < 3; m++)
							list.add(arr[m]);
						if (!res.contains(list))
							res.add(list);
					}
				}
			}
		}
		return res;
	}
}
