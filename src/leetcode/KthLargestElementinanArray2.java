package leetcode;

/* Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementinanArray2 {
	public int findKthLargest(int[] nums, int k) {
		int len = nums.length;
		// if(len == 0) return 0; //we get to assume k is always valid
		Queue<Integer> pq = new PriorityQueue<>(len,
				(Integer a, Integer b)  -> Integer.compare(b, a));
		for(int num : nums)
			pq.offer(num);

		int kth = 0;
		for(int i = 0; i < k; i++)
			kth = pq.poll();

		return kth;
	}
}
