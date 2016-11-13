package leetcode;

/**
 * Given a list of numbers, a[0], a[1], a[2], … , a[N-1], where 0 <= a[i] < 2^32. Find the maximum result of a[i] XOR a[j].

 Could you do this in O(n) runtime?

 Input: [3, 10, 5, 25, 2, 8]
 Output: 28
 */
//brute force
public class MaximumXORoTwoNumbersinanArray2 {
    public static  int findMaximumXOR(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    res = res > (nums[i] ^ nums[j]) ? res : (nums[i] ^ nums[j]);
                }
            }
        }
        return res;
    }
    public static  void main(String[] args){
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(findMaximumXOR(nums));
    }
}
