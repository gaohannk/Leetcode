package leetcode.algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.
 *
 * Example 1:
 * Input: [1,2,3,4,5], k=4, x=3
 * Output: [1,2,3,4]
 * Example 2:
 * Input: [1,2,3,4,5], k=4, x=-1
 * Output: [1,2,3,4]
 * Note:
 * The value k is positive and will always be smaller than the length of the sorted array.
 * Length of the given array is positive and will not exceed 104
 * Absolute value of elements in the array and x will not exceed 104
 */

/**
 * Assume we are taking A[i] ~ A[i + k -1].
 * We can binary research i
 * We compare the distance between x - A[mid] and A[mid + k] - x
 *
 * If x - A[mid] > A[mid + k] - x,
 * it means A[mid + 1] ~ A[mid + k] is better than A[mid] ~ A[mid + k - 1],
 * and we have mid smaller than the right i.
 * So assign left = mid + 1.
 *
 * Note that, you SHOULD NOT compare the absolute value of abs(x - A[mid]) and abs(A[mid + k] - x).
 * It fails at cases like A = [1,1,2,2,2,2,2,3,3], x = 3, k = 3
 */
public class FindKClosestElements2 {
    public List<Integer> findClosestElements(int[] A, int k, int x) {
        int left = 0, right = A.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - A[mid] > A[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        return Arrays.stream(A, left, left + k).boxed().collect(Collectors.toList());
    }
}
