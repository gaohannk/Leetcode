package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumSizeSubarraySum3 {
	public static int minSubArrayLen(int s, int[] nums) {
		Deque<Integer> queue = new LinkedList<>();
		int minLength = Integer.MAX_VALUE;
		int sum = 0;
		for (int num : nums) {
			sum += num;
			queue.offer(num);
			if (sum >= s) {
				while (sum - queue.peek() >= s)
					sum -= queue.poll();
				minLength = Math.min(minLength, queue.size());
			}
		}
		return sum < s ? 0 : minLength;
	}
}
