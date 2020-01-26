package company.databricks.phone;

import java.util.ArrayDeque;
import java.util.Deque;

/* Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
*/
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[0];
        if (k == 1)
            return nums;

        int[] res = new int[nums.length - k + 1];
        // store index
        Deque<Integer> deq = new ArrayDeque<Integer>();

        for (int i = 0; i < nums.length; i++) {
            // Remove numbers that fell out from the left side.
            if (!deq.isEmpty() && deq.getFirst() <= i - k)
                deq.removeFirst();
            // Remove any numbers from the right side that are smaller or equal to the current number, since they will not affect the window maximum
            // after we add the current number.
            while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
                deq.removeLast();
            }
            // Add current index to right side of window.
            deq.addLast(i);
            if (i >= k - 1) {
                // The leftmost number in the window must be the current largest
                // number, because if this were not true, then we would already
                // have removed it earlier.
                res[i - k + 1] = nums[deq.getFirst()];
            }

        }
        return res;
    }
}
