package leetcode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 ≤ i ≤ N) in this array:
 * <p>
 * The number at the ith position is divisible by i.
 * i is divisible by the number at the ith position.
 * Now given N, how many beautiful arrangements can you construct?
 * <p>
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation:
 * <p>
 * The first beautiful arrangement is [1, 2]:
 * <p>
 * Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
 * <p>
 * Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
 * <p>
 * The second beautiful arrangement is [2, 1]:
 * <p>
 * Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
 * <p>
 * Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 * Note:
 * N is a positive integer and will not exceed 15.
 */
public class BeautifulArrangement {
    static int res;

    public static int countArrangement(int N) {
        boolean flag[] = new boolean[N+1];
        putNumber(1, flag, N);
        return res;
    }

    public static void putNumber(int index, boolean[] flag, int N) {
        if (index == N + 1) {
            res++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (flag[i] == false && (i % index == 0 || index % i == 0)) {
                flag[i] = true;
                putNumber(index + 1, flag, N);
                flag[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.print(countArrangement(10));
    }
}
