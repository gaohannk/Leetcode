package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.
 * Note:
 * A naive algorithm of O(n2) is trivial. You MUST do better than that.
 * Example:
 * Given nums = [-2, 5, -1], lower = -2, upper = 2,
 * Return 3.
 * The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
 */
/* Let sum[i] be the prefix sum of nums[..i]. Then the range-sum of [i, j] is equal to sum[j] - sum[i - 1]. 
 * We enumerate all i's. For any fixed i, we need to count the number of j's satisfying lower ≤ sum[j] - sum[i - 1] ≤ upper, 
 * i.e., lower + sum[i - 1] ≤ sum[j] ≤ upper + sum[i - 1], for all i ≤ j ≤ n. 
 * This kind of query can be answered, in O(log n) time, by using data structures like Fenwick Tree or Segment Tree. 
 * Therefore, the total runtime is O(n log n).
 */
public class CountofRangeSum2 {
	public int countRangeSum(int[] nums, int lower, int upper) {
		List<Long> cand = new ArrayList<>();
		cand.add(Long.MIN_VALUE); // make sure no number gets a 0-index.
		cand.add(0L);
		long[] sum = new long[nums.length + 1];
		for (int i = 1; i < sum.length; i++) {
			sum[i] = sum[i - 1] + nums[i - 1];
			cand.add(sum[i]);
			cand.add(lower + sum[i - 1] - 1);
			cand.add(upper + sum[i - 1]);
		}
		Collections.sort(cand); // finish discretization

		int[] bit = new int[cand.size()];
		for (int i = 0; i < sum.length; i++)
			plus(bit, Collections.binarySearch(cand, sum[i]), 1);
		int ans = 0;
		for (int i = 1; i < sum.length; i++) {
			plus(bit, Collections.binarySearch(cand, sum[i - 1]), -1);
			ans += query(bit, Collections.binarySearch(cand, upper + sum[i - 1]));
			ans -= query(bit, Collections.binarySearch(cand, lower + sum[i - 1] - 1));
		}
		return ans;
	}

	private void plus(int[] bit, int i, int delta) {
		for (; i < bit.length; i += i & -i)
			bit[i] += delta;
	}

	private int query(int[] bit, int i) {
		int sum = 0;
		for (; i > 0; i -= i & -i)
			sum += bit[i];
		return sum;
	}
}
