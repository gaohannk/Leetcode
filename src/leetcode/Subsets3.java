package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/* Given a set of distinct integers, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets3 {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<Integer>());
		for (int i = 0; i < S.length; i++) {
			for (int j = 0; j <  result.size(); j++) {
				ArrayList<Integer> temp = new ArrayList<Integer>(result.get(j));
				temp.add(S[i]);
				result.add(temp);
			}
		}
		return result;
	}

}
