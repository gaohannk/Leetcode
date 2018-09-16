package leetcode;

/**
 * Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.

 If there aren't two consecutive 1's, return 0.



 Example 1:

 Input: 22
 Output: 2
 Explanation:
 22 in binary is 0b10110.
 In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
 The first consecutive pair of 1's have distance 2.
 The second consecutive pair of 1's have distance 1.
 The answer is the largest of these two distances, which is 2.
 Example 2:

 Input: 5
 Output: 2
 Explanation:
 5 in binary is 0b101.
 Example 3:

 Input: 6
 Output: 1
 Explanation:
 6 in binary is 0b110.
 Example 4:

 Input: 8
 Output: 0
 Explanation:
 8 in binary is 0b1000.
 There aren't any consecutive pairs of 1's in the binary representation of 8, so we return 0.


 Note:
 */

/**
 * Intuition

 Since we wanted to inspect the distance between consecutive 1s in the binary representation of N, let's write down the index of each 1 in that binary representation. For example, if N = 22 = 0b10110, then we'll write A = [1, 2, 4]. This makes it easier to proceed, as now we have a problem about adjacent values in an array.

 Algorithm

 Let's make a list A of indices i such that N has the ith bit set.

 With this array A, finding the maximum distance between consecutive 1s is much easier: it's the maximum distance between adjacent values of this array.
 Complexity Analysis

 Time Complexity: O(\log N)O(logN). Note that \log NlogN is the number of digits in the binary representation of NN.

 Space Complexity: O(\log N)O(logN), the space used by A.
 */
public class BinaryGap {
    public int binaryGap(int N) {
        int[] A = new int[32];
        int ans = 0, idx = 0;
        for (int i = 0; i < 32; ++i)
            if (((N >> i) & 1) != 0)
                A[idx++] = i;


        for (int i = 0; i < idx - 1; i++)
            ans = Math.max(ans, A[i+1] - A[i]);
        return ans;
    }
}
