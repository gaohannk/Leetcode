package leetcode;

/* You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
// DP Time O(n) Space O(1)
public class ClimbingStairs3 {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        int[] res = new int[3];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i % 3] = res[(i - 1) % 3] + res[(i - 2) % 3];
        }
        return res[n % 3];
    }

    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
