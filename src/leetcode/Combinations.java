package leetcode;

import java.util.ArrayList;

/* Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		combinehelper(n, 1, k, list, res);
		return res;
	}

	public void combinehelper(int n, int start, int k, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res) {
		if (list.size() == k) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = start; i <= n; i++) {
			list.add(i);
			combinehelper(n, i + 1, k, list, res);
			list.remove(list.size() - 1);
		}
	}
}
