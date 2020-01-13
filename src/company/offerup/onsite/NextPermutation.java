package company.offerup.onsite;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return;
        int id = nums.length - 1;
        while (id - 1 >= 0) {
            if (nums[id] <= nums[id - 1]) {
                id--;
                continue;
            } else {
                break;
            }
        }
        int head = -1;
        if (id != 0) {
            int val = nums[id - 1];
            head = id - 1;
            id = nums.length - 1;
            while (nums[id] <= val) {
                id--;
            }
            swap(nums, head, id);
        }
        int p = nums.length - 1;
        for (int i = head + 1; i < (nums.length + head) / 2 + 1; i++) {
            swap(nums, i, p--);
        }
    }

    private void swap(int[] nums, int head, int id) {
        int temp = nums[head];
        nums[head] = nums[id];
        nums[id] = temp;
    }
}
