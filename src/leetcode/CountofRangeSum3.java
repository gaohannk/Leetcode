package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
public class CountofRangeSum3 {
	class SegmentTreeNode {
		SegmentTreeNode left;
		SegmentTreeNode right;
		int count;
		long min;
		long max;

		public SegmentTreeNode(long min, long max) {
			this.min = min;
			this.max = max;
		}
	}

	private SegmentTreeNode buildSegmentTree(Long[] valArr, int low, int high) {
		if (low > high)
			return null;
		SegmentTreeNode stn = new SegmentTreeNode(valArr[low], valArr[high]);
		if (low == high)
			return stn;
		int mid = (low + high) / 2;
		stn.left = buildSegmentTree(valArr, low, mid);
		stn.right = buildSegmentTree(valArr, mid + 1, high);
		return stn;
	}

	private void updateSegmentTree(SegmentTreeNode stn, Long val) {
		if (stn == null)
			return;
		if (val >= stn.min && val <= stn.max) {
			stn.count++;
			updateSegmentTree(stn.left, val);
			updateSegmentTree(stn.right, val);
		}
	}

	private int getCount(SegmentTreeNode stn, long min, long max) {
		if (stn == null)
			return 0;
		if (min > stn.max || max < stn.min)
			return 0;
		if (min <= stn.min && max >= stn.max)
			return stn.count;
		return getCount(stn.left, min, max) + getCount(stn.right, min, max);
	}

	public int countRangeSum(int[] nums, int lower, int upper) {
		if (nums == null || nums.length == 0)
			return 0;
		int ans = 0;
		Set<Long> valSet = new HashSet<Long>();
		long sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += (long) nums[i];
			valSet.add(sum);
		}

		Long[] valArr = valSet.toArray(new Long[0]);

		Arrays.sort(valArr);
		SegmentTreeNode root = buildSegmentTree(valArr, 0, valArr.length - 1);
		// Why updateSegmentTree and getCount in one loop
		for (int i = nums.length - 1; i >= 0; i--) {
			updateSegmentTree(root, sum); 
			sum -= (long) nums[i];
			ans += getCount(root, (long) lower + sum, (long) upper + sum);
		}
		return ans;
	}
}
