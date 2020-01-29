package company.databricks.phone;
// O(n) space
public class FirstMissingPositive2 {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        int i = 0;
        boolean[] exist = new boolean[nums.length];
        while (i < nums.length) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                i++;
            } else {
                exist[nums[i] - 1] = true;
                i++;
            }
        }
        for (i = 0; i < exist.length; i++) {
            if (exist[i] == false) {
                return i + 1;
            }
        }
        return exist.length + 1;
    }
}
