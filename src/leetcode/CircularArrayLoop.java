package leetcode;

import java.util.HashSet;

/**
 * You are given an array of positive and negative integers. If a number n at an index is positive, then move forward n steps. Conversely, if it's negative (-n), move backward n steps. Assume the first element of the array is forward next to the last element, and the last element is backward next to the first element. Determine if there is a loop in this array. A loop starts and ends at a particular index with more than 1 element along the loop. The loop must be "forward" or "backward'.
 * <p>
 * Example 1: Given the array [2, -1, 1, 2, 2], there is a loop, from index 0 -> 2 -> 3 -> 0.
 * <p>
 * Example 2: Given the array [-1, 2], there is no loop.
 * <p>
 * Note: The given array is guaranteed to contain no element "0".
 * <p>
 * Can you do it in O(n) time complexity and O(1) space complexity?
 */
public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        for (int curIndex = 0; curIndex < nums.length; curIndex++) {
            if (nums[curIndex] == 0)
                continue;

            int slow = curIndex, fast = getIndex(curIndex, nums);
            while (nums[fast] * nums[curIndex] > 0 && nums[getIndex(fast, nums)] * nums[curIndex] > 0) {
                if (slow == fast) {
                    // check for loop with only one element
                    if (slow == getIndex(slow, nums))
                        break;
                    return true;
                }
                slow = getIndex(slow, nums);
                fast = getIndex(getIndex(fast, nums), nums);
            }
            // loop not found, set all element along the way to 0
            slow = curIndex;
            while (nums[slow] * nums[curIndex] > 0) {
                int next = getIndex(slow, nums);
                nums[slow] = 0;
                slow = next;
            }
        }
        return false;
    }

    public int getIndex(int i, int[] nums) {
        int n = nums.length;
        return i + nums[i] >= 0 ? (i + nums[i]) % n : n + ((i + nums[i]) % n);
    }
}
