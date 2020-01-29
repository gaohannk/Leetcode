package company.databricks.phone;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                i++;
            } else if (nums[i] != i + 1 && nums[i] - 1 < nums.length && nums[i] - 1 >= 0 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        for(int j=0;j<nums.length;j++){
            System.out.print(nums[j]+",");
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
