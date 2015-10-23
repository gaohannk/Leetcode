package leetcode;

import java.util.*;

/* Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *     A solution set is:
 *       (-1,  0, 0, 1)、
 *       (-2, -1, 1, 2)
 *       (-2,  0, 0, 2)
 */
public class FourSum2 {
	class Pair {
		int first; // The first index
		int second; // The second index

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int n = num.length;
		if (n < 4) // Contains less than four numbers
			return result;
		Arrays.sort(num); // Sort the array in non-descending order
		// Record the sum of each pair using a map, with the sum as the key
		// and the indices of the pair as the value
		HashMap<Integer, ArrayList<Pair>> hashMap = new HashMap<Integer, ArrayList<Pair>>();
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (hashMap.containsKey(num[i] + num[j])) // Existing sum (key)
					hashMap.get(num[i] + num[j]).add(new Pair(i, j));
				else { // new sum (key)
					ArrayList<Pair> pairs = new ArrayList<Pair>();
					pairs.add(new Pair(i, j));
					hashMap.put(num[i] + num[j], pairs);
				}
			}
		}
		// For each unique pair (num[i],num[j]) as the first two numbers in a
		// quadruple,search the map with target-num[i]-num[j] and get the
		// remaining two numbers without duplicates
		for (int i = 0; i < n - 3; i++) {
			if (i > 0 && num[i] == num[i - 1])
				// All quadruples starting with num[i] have included before
				continue;
			for (int j = i + 1; j < n - 2; j++) {
				if (j > i + 1 && num[j] == num[j - 1])
					// All quadruples starting with (num[i],num[j]) have
					// included before
					continue;
				int wanted = target - num[i] - num[j];
				if (hashMap.containsKey(wanted)) { // There is at least a pair
													// whose sum is wanted
					for (Pair pair : hashMap.get(wanted)) {
						if (pair.first <= j) // The third number has to be after
												// the second one in the array
							continue;
						if (result.isEmpty() || result.get(result.size() - 1).get(0) != num[i]
								|| result.get(result.size() - 1).get(1) != num[j]
								|| result.get(result.size() - 1).get(2) != num[pair.first]) { // no
																								// duplicate
							ArrayList<Integer> quadruple = new ArrayList<Integer>(4);
							quadruple.add(num[i]);
							quadruple.add(num[j]);
							quadruple.add(num[pair.first]);
							quadruple.add(num[pair.second]);
							result.add(quadruple);
						}
					}
				}
			}
		}
		return result;
	}
}
