package leetcode.algo.f;

/* Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
/* 类似于检测链表中是否有环
 * O(n)
 */
public class FindtheDuplicateNumber2 {
	public int findDuplicate(int[] nums) {
		int slow = 0;
		int fast = 0;
		while (true) {
			slow = nums[slow];
			fast = nums[nums[fast]];
			if (slow == fast)
				break;
		}
		slow = 0;
		while (true) {
			slow = nums[slow];
			fast = nums[fast];
			if (fast == slow)
				break;
		}
		return slow;
	}
}
