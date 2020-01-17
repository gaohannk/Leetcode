package leetcode.algo.l;

import java.util.Arrays;

/* Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 */
/* 简单来说，排序后遍历数组，检查与前一个值是否差1，如果是，增加当前连续序列的计数；如果大于1，将当前计数与当前最大值比较，如果更优替换最大值，
 * 并重置计数为1，如果等于0，则说明重复。
 * 1 排序
 * 2 用count计数，记下连续数字的个数
 * 1）连续，count++
 * 2）不连续，count=1，重新计数，重新计数前要保留并更新结果。
 * 3）重复，continue
 */
// O(nlogn)
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);
		int count = 1, res = 1;
		for (int i = 1; i < nums.length; i++) {
			// Don't forget this
			if (nums[i] == nums[i - 1]) {
				continue;
			}
			if (nums[i] == nums[i - 1] + 1) {
				count++;
			} else {
				res = Math.max(res, count);
				count = 1;
			}
		}
		res = Math.max(res, count);
		return res;
	}
}
