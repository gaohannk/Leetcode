package leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*Given an integer n, return 1 - n in lexicographical order.
For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
*/
public class LexicographicalNumbers2 {
	public List<Integer> lexicalOrder(int n) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= 9; i++) {
			dfs(i, n, list);
		}
		return list;
	}

	private void dfs(int i, int n, LinkedList<Integer> list) {
		if (i > n)
			return;
		list.add(i);
		for (int j = 0; j < 10; j++) {// append 0-9 to the end of i
			if (i * 10 + j <= n)
				dfs(i * 10 + j, n, list);
			else
				// Prune to in case of TLE
				break;
		}
	}
}
