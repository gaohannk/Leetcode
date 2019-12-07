package leetcode.algo.f;

import java.util.*;

/**
 * LeetCode 888
 */
public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int delta = (Arrays.stream(A).sum() - Arrays.stream(B).sum()) / 2;
        Set<Integer> setB = new HashSet();
        for (int x : B) {
            setB.add(x);
        }

        for (int x : A) {
            if (setB.contains(x + delta)) {
                return new int[]{x, x + delta};
            }
        }
        return null;
    }

    public int[] fairCandySwap2(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        for (int n : A) sumA += n;
        for (int n : B) sumB += n;
        int target = (sumA + sumB) / 2 - sumA;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : A) {
            if (!map.containsKey(target + n)) {
                map.put(target + n, n);
            }
        }
        for (int n : B) {
            if (map.containsKey(n)) {
                return new int[]{map.get(n), n};
            }
        }
        return new int[]{0, 0};
    }
}
