package leetcode.algo.m;

import java.util.HashSet;

public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        int[] top = new int[7];
        int[] bot = new int[7];
        for (int i = 0; i < A.length; i++) {
            top[A[i]]++;
            bot[B[i]]++;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= 6; i++) {
            if (top[i] + bot[i] >= A.length)
                set.add(i);
        }
        int solution = Integer.MAX_VALUE;
        outer:
        for (int i : set) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] != i && B[j] != i)
                    continue outer;//both top and bot doesn't have the expected domino
                if (top[i] > bot[i] && A[j] != i) {//thre are more dominos == i on top, flip bot is better
                    count++;
                }
                if (top[i] < bot[i] && B[j] != i) {//thre are more dominos == i on bot, flip top is better
                    count++;
                }
            }
            solution = Math.min(solution, count);
        }

        return solution == Integer.MAX_VALUE ? -1 : solution;
    }
}
