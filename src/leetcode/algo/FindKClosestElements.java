package leetcode.algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new LinkedList<>();
        Pair[] pairs = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pairs[i] = new Pair(Math.abs(arr[i] - x), i);
        }
        Arrays.sort(pairs);
        for (int i = 0; i < k; i++) {
            res.add(arr[pairs[i].idx]);
        }
        Collections.sort(res);
        return res;
    }

    class Pair implements Comparable<Pair> {
        int diff;
        int idx;

        public Pair(int diff, int idx) {
            this.diff = diff;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair o) {
            return this.diff - o.diff;
        }
    }
}
