package leetcode.m;

/**
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.
 * <p>
 * There is at least one empty seat, and at least one person sitting.
 * <p>
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 * <p>
 * Return that maximum distance to closest person.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation:
 * If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 * Example 2:
 * <p>
 * Input: [1,0,0,0]
 * Output: 3
 * Explanation:
 * If Alex sits in the last seat, the closest person is 3 seats away.
 * This is the maximum distance possible, so the answer is 3.
 * Note:
 * <p>
 * 1 <= seats.length <= 20000
 * seats contains only 0s or 1s, at least one 0, and at least one 1.
 */

import java.util.Arrays;

/**
 * Next Array MinDeleteNoMoreThanThree
 * time O(N)
 * space O(N)
 */
public class MaximizeDistancetoClosestPerson {
    public static int maxDistToClosest(int[] seats) {
        int N = seats.length;
        int[] left = new int[N], right = new int[N];
        Arrays.fill(left, N);
        Arrays.fill(right, N);

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1)
                left[i] = 0;
            else if (i > 0)
                left[i] = left[i - 1] + 1;
        }

        for (int i = N - 1; i >= 0; --i) {
            if (seats[i] == 1)
                right[i] = 0;
            else if (i < N - 1)
                right[i] = right[i + 1] + 1;
        }

        int ans = 0;
        for (int i = 0; i < N; ++i) {
            if (seats[i] == 0) {
                ans = Math.max(ans, Math.min(left[i], right[i]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] seats = {0, 0, 1};
        maxDistToClosest(seats);
    }
}
