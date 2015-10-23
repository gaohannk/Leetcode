package leetcode;

import java.util.Arrays;

/* Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Try to solve it in linear time/space.
 * Return 0 if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
/* Suppose there are N elements and they range from A to B.
 * Then the maximum gap will be no smaller than ceiling[(B - A) / (N - 1)]
 * Let the length of a bucket to be len = ceiling[(B - A) / (N - 1)], then we will have at most num = (B - A) / len + 1 of bucket
 * for any number K in the array, we can easily find out which bucket it belongs by calculating loc = (K - A) / len and therefore maintain the maximum and minimum elements in each bucket.
 * Since the maximum difference between elements in the same buckets will be at most len - 1, so the final answer will not be taken from two elements in the same buckets.
 * For each non-empty buckets p, find the next non-empty buckets q, then q.min - p.max could be the potential answer to the question. Return the maximum of all those values.
 */
public class MaximumGap2 {
	public int maximumGap(int[] num) {
		int n = num.length;
		if (num == null || n < 2)
			return 0;
		int min = num[0];
		int max = num[0];
		for (int i : num) {
			if (i > max)
				max = i;
			else if (i < min)
				min = i;
		}
		double dist = (double) (max - min) / (double) (n - 1);
		int[] mins = new int[n - 1];
		int[] maxs = new int[n - 1];
		Arrays.fill(mins, -1);
		Arrays.fill(maxs, -1);
		for (int i : num) {
			int idx = (i == max ? n - 2 : (int) ((i - min) / dist));
			if (mins[idx] == -1 || i < mins[idx])
				mins[idx] = i;

			if (maxs[idx] == -1 || i > maxs[idx])
				maxs[idx] = i;

		}
		int prevMax = maxs[0];
		int maxGap = maxs[0] - mins[0];
		for (int i = 1; i < n - 1; i++) {
			if (mins[i] == -1)
				continue;

			int gap = mins[i] - prevMax;
			if (gap > maxGap)
				maxGap = gap;

			prevMax = maxs[i];
		}
		return maxGap;
	}
}
