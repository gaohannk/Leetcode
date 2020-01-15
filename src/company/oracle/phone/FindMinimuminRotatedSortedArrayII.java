package company.oracle.phone;

public class FindMinimuminRotatedSortedArrayII {

    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] >= nums[start] && nums[mid] > nums[end]) {
            return helper(nums, mid + 1, end);
        } else if (nums[mid] <= nums[start] && nums[mid] < nums[end]) {
            return helper(nums, start, mid);
        }
        return Math.min(helper(nums, start, mid ), helper(nums, mid+1, end));
    }
}
