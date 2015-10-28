package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Ensure that numbers within the set are sorted in ascending order.
 * Example 1:
 * Input: k = 3, n = 7
 * Output:[[1,2,4]]
 * Example 2:
 * Input: k = 3, n = 9
 * Output:[[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {
	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		LinkedList<Integer> set = new LinkedList<Integer>();
		HashSet<Integer> hash = new HashSet<>();
		helper(k, n, 0, res, set, hash);
		return res;
	}

	public static void helper(int k, int n, int sum, List<List<Integer>> res, LinkedList<Integer> set,
			HashSet<Integer> hash) {
		if (sum == n && k == 0) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			list = set;
			res.add(list);
			return;
		}
		if (sum > n)
			return;
		if (k < 0)
			return;

		for (int i = 0; i < 10; i++) {
			if (!hash.contains(i)) {
				hash.add(i);
				set.add(i);
				sum += i;
				helper(k - 1, n, sum, res, set, hash);
				sum -= i;
				hash.remove(i);
				set.remove(set.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> res=combinationSum3(8, 36);
		for(List<Integer> l : res){
			for(int i=0;i<l.size();i++){
				System.out.print(l.get(i)+" ");
			}
			System.out.println();
		}
	}
}
