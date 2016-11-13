package leetcode;

import java.util.Arrays;

/**
 * Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.

 Note: 1 ≤ k ≤ n ≤ 109.

 Example:

 Input:
 n: 13   k: 2

 Output:
 10

 Explanation:
 The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
 */
//MLE
public class KthSmallestinLexicographicalOrder {
    public static int findKthNumber(int n, int k) {
        String[] nums = new String[n+1];
        nums[0]="0";
        for(int i=1;i<=n;i++){
            nums[i]= ""+i;
        }
        Arrays.sort(nums);

        return Integer.parseInt(nums[k]);
    }
    public static void main(String[] args) {
        System.out.println(findKthNumber(20, 3));
    }


}
