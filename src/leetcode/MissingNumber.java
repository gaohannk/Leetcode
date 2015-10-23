package leetcode;
/*
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * For example,
 * Given nums = [0, 1, 3] return 2.
 */
import java.util.Arrays;

public class MissingNumber {
	public int missingNumber(int[] nums) {
		if(nums==null||nums.length==0)
			return 0;
		Arrays.sort(nums);
		for(int i=0;i<nums.length-1;i++){
			if(nums[i]+1!=nums[i+1])
				return nums[i]+1;
		}
		if(nums[0]==0)
			return nums[nums.length-1]+1;
		else
			return 0;
	}
}
