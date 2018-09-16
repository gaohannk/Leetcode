package leetcode;

import java.util.TreeMap;

/**
 * Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].
 * <p>
 * Return any permutation of A that maximizes its advantage with respect to B.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [2,7,11,15], B = [1,10,4,11]
 * Output: [2,11,7,15]
 * Example 2:
 * <p>
 * Input: A = [12,24,8,32], B = [13,25,32,11]
 * Output: [24,32,8,12]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length = B.length <= 10000
 * 0 <= A[i] <= 10^9
 * 0 <= B[i] <= 10^9
 */
public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        int[] res = new int[A.length];
        TreeMap<Integer, Integer> map = new TreeMap();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        // for each value in B, get the A entry with smallest higher key or the smallest key if not exist
        for (int i = 0; i < B.length; i++) {
            int key;
            if (map.higherEntry(B[i]) != null) {
                key = map.higherKey(B[i]);
            } else {
                key = map.firstKey();
            }
            res[i] = key;
            if (map.get(key) == 1)
                map.remove(key);
            else
                map.put(key, map.get(key) - 1);
        }

        return res;

    }
}
