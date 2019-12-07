package leetcode.algo.c;
/* You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

// Brute Force
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs2(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(n, memo);
    }

    public int climb_Stairs(int n, int memo[]) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (memo[n] > 0)
            return memo[n];
        memo[n] = climb_Stairs(n - 1, memo) + climb_Stairs(n - 2, memo);
        return memo[n];
    }
}
