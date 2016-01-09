package leetcode;
/*
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * For example,
 * Given nums = [0, 1, 3] return 2.
 */
public class MissingNumber2 {
	public int missingNumber(int[] nums) {
	    int n = nums.length;
	    int sum = (1 + n) * n / 2;

	    for(int i = 0; i < nums.length; i++){
	        sum = sum - nums[i];
	    }

	    return sum;
	}
}
