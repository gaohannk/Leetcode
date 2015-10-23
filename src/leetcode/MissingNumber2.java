package leetcode;

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
