package leetcode.algo.t;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians), return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest.
 *
 * A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j, or they have the same number of soldiers but i is less than j. Soldiers are always stand in the frontier of a row, that is, always ones may appear first and then zeros.
 *
 *
 *
 * Example 1:
 *
 * Input: mat =
 * [[1,1,0,0,0],
 * [1,1,1,1,0],
 * [1,0,0,0,0],
 * [1,1,0,0,0],
 * [1,1,1,1,1]],
 * k = 3
 * Output: [2,0,3]
 * Explanation:
 * The number of soldiers for each row is:
 * row 0 -> 2
 * row 1 -> 4
 * row 2 -> 1
 * row 3 -> 2
 * row 4 -> 5
 * Rows ordered from the weakest to the strongest are [2,0,3,1,4]
 * Example 2:
 *
 * Input: mat =
 * [[1,0,0,0],
 * [1,1,1,1],
 * [1,0,0,0],
 * [1,0,0,0]],
 * k = 2
 * Output: [0,2]
 * Explanation:
 * The number of soldiers for each row is:
 * row 0 -> 1
 * row 1 -> 4
 * row 2 -> 1
 * row 3 -> 1
 * Rows ordered from the weakest to the strongest are [0,2,3,1]
 */
public class TheKWeakestRowsinaMatrix {
    class Pair {
        int rowId;
        int solders;

        public Pair(int id, int count) {
            this.rowId = id;
            this.solders = count;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.solders == o2.solders) {
                    return o1.rowId - o2.rowId;
                }
                return o1.solders - o2.solders;
            }
        });
        int id = 0;
        for (int[] row : mat) {
            int count = 0;
            for (int i = 0; i < row.length; i++) {
                if (row[i] == 1) {
                    count++;
                }
            }
            pq.add(new Pair(id, count));
            id++;
        }
        int[] res = new int[k];
        int i = 0;
        while (i < k) {
            res[i++] = pq.poll().rowId;
        }
        return res;
    }
}
