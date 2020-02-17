package leetcode.algo.v;

import java.util.Arrays;

/**
 * Given the coordinates of four points in 2D space, return whether the four points could construct a square.
 *
 * The coordinate (x,y) of a point is represented by an integer array with two integers.
 *
 * Example:
 *
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * Output: True
 *
 *
 * Note:
 *
 * All the input integers are in the range [-10000, 10000].
 * A valid square has four equal sides with positive length and four equal angles (90-degree angles).
 * Input points have no order.
 */
// brute force permutation
public class ValidSquare {
    public double dist(int[] p1, int[] p2) {
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
    }

    public boolean check(int[] p1, int[] p2, int[] p3, int[] p4) {
        return dist(p1, p2) > 0 && dist(p1, p2) == dist(p2, p3) && dist(p2, p3) == dist(p3, p4) && dist(p3, p4) == dist(p4, p1) && dist(p1, p3) == dist(p2, p4);
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = {p1, p2, p3, p4};
        return checkAllPermutations(p, 0);
    }

    boolean checkAllPermutations(int[][] p, int cur) {
        if (cur == 4) {
            return check(p[0], p[1], p[2], p[3]);
        } else {
            boolean res = false;
            for (int i = cur; i < 4; i++) {
                swap(p, cur, i);
                res |= checkAllPermutations(p, cur + 1);
                swap(p, cur, i);
            }
            return res;
        }
    }

    public void swap(int[][] p, int x, int y) {
        int[] temp = p[x];
        p[x] = p[y];
        p[y] = temp;
    }
}

