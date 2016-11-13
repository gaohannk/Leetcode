package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

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
public class KthSmallestinLexicographicalOrder2 {
    public static int findKthNumber(int n, int k) {
        for (int i = 1; i <= 9; i++) {
           return dfs(i, n,k);
        }
        return 0;
    }

    private static int dfs(int i, int n, int k ) {
        if (i > k)
            return i+1;

        for (int j = 0; j < 10; j++) {// append 0-9 to the end of i
            if (i * 10 + j <= k)
               return dfs(i * 10 + j, n,k);
            else
                // Prune to in case of TLE
                break;
        }
        return i+1;
    }

    public static void main(String[] args) {
        System.out.println(findKthNumber(20, 3));
    }


}
