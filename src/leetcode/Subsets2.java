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
/* Given a set S of n distinct integers, there is a relation between Sn and Sn-1. 
 * The subset of Sn-1 is the union of {subset of Sn-1} and {each element in Sn-1 + one more element}. 
 */
/* 注意：
 * 1. 结果要求生成升序排列，所以最开始的时候我们需要Sort
 * 2. 往res里面添加的时候要 new ArrayList(tmp);
 * 3. 空集也是子集
 */
public class Subsets2 {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		Arrays.sort(S);
		res.add(tmp);
		dfs(res, tmp, S, 0);
		return res;
	}

	public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] S, int pos) {
		for (int i = pos; i <= S.length - 1; i++) {
			tmp.add(S[i]);
			res.add(new ArrayList<Integer>(tmp));
			dfs(res, tmp, S, i + 1);
			tmp.remove(tmp.size() - 1);
		}
	}
}
