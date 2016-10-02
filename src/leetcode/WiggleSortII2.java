package leetcode;

import java.util.Arrays;

/* Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * Example:
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * Note:
 * You may assume all input has valid answer.
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
//TLE O(nlogn)
public class WiggleSortII2 {

	public static void wiggleSort(int[] nums) {
		int newNum[] = Arrays.copyOf(nums, nums.length);
		Arrays.sort(newNum);
		for(int i=0;i<nums.length;i=i+2){
			nums[i]=newNum[i/2];
		}
		for(int i=1;i<nums.length;i=i+2){
			nums[i]=newNum[nums.length-1-i/2];
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 5, 1, 1, 6, 4 };
		wiggleSort(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}

}
