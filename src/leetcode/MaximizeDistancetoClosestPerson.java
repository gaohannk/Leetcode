package leetcode;

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
/**
 * Next Array Solution
 */
public class MaximizeDistancetoClosestPerson {
    public static int maxDistToClosest(int[] seats) {
        int[] next = new int[seats.length];
        int cur = -1;
        // Update next seat position
        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                cur = i;
            }
            next[i] = cur;
        }

        int res = 0;
        cur = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1)
                cur = i;
            if (next[i] == -1) // right no 1
                res = Math.max(res, i - cur);
            if (cur == -1) // left no 1
                res = Math.max(res, next[i]);
            else
                res = Math.max(res, Math.min(i - cur, next[i] - i));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] seats = {0, 0, 1};
        maxDistToClosest(seats);
    }
}
