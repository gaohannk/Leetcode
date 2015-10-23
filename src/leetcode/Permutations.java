package leetcode;

/* Given a collection of numbers, return all possible permutations.
 * For example, 
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
import java.util.ArrayList;

public class Permutations {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<Integer>());
		for (int i = 0; i < num.length; i++) {
			ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> l : result) {
				for (int j = 0; j < l.size() + 1; j++) {
					// + add num[i] to different locations
					l.add(j, num[i]);
					 new ArrayList<Integer>(l);
					current.add(new ArrayList<Integer>(l));
					// - remove num[i] add
					l.remove(j);
				}
			}
			result = new ArrayList<ArrayList<Integer>>(current);
		}
		return result;
	}
}
