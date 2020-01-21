package company.smartnews.oa;

import java.util.*;

/**
 * Integer V lies strictly between integers U and W if U < V < W or if U > V > W.
 * A non-empty zero-indexed array A consisting of N integers is given.
 * A pair of indices (P, Q), where 0 <= P < Q < N, is said to have adjacent values if no value
 * in the array lies strictly between values A[P] and A[Q]
 *
 * For example, in array A such that: [0, 3, 3, 7, 5, 3, 11, 1]
 * the following pairs of indices have adjacent values:
 * (0, 7), (1, 2), (1, 4),
 * (1, 5), (1, 7), (2, 4),
 * (2, 5), (2, 7), (3, 4),
 * (3, 6), (4, 5), (5, 7)
 * For example, indices 4 and 5 have adjacent values because there is no value in array A that lies .
 * strictly between A[4] = 5 and A[5] = 3; the only such value could be the number 4,
 * and it is not present in the array.
 *
 * Write a function that returns the maximum distance between indices that have adjacent values
 */
public class Problem5 {
    static class Pair {
        int val;
        int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "val=" + val +
                    ", index=" + index +
                    '}';
        }
    }

    public static int findSolution(int[] array) {
        List<Pair> list = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(new Pair(array[i], i));
        }

        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.val == o2.val) {
                    return o1.index - o2.index;
                }
                return o1.val - o2.val;
            }
        });

        int maxDis = 0;
        for (int i = 0; i < list.size(); i++) {
            int start = i;
            int count = 0;
            while (start + 1 < list.size() && count < 2) {
                if (list.get(start + 1).val != list.get(start).val) {
                    count++;
                }
                if (count < 2) {
                    int curDis = Math.abs(list.get(start + 1).index - list.get(i).index);
                    maxDis = Math.max(maxDis, curDis);
                    start++;
                }
            }

        }
        return maxDis;
    }

    public static void main(String[] args) {
        int[] array = {0, 3, 3, 7, 5, 3, 11, 1};
        System.out.println(findSolution(array));
    }
}
