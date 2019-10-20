package leetcode.n;

/**
 * A positive integer is magical if it is divisible by either A or B.
 * <p>
 * Return the N-th magical number.  Since the answer may be very large, return it modulo 10^9 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: N = 1, A = 2, B = 3
 * Output: 2
 * Example 2:
 * <p>
 * Input: N = 4, A = 2, B = 3
 * Output: 6
 * Example 3:
 * <p>
 * Input: N = 5, A = 2, B = 4
 * Output: 10
 * Example 4:
 * <p>
 * Input: N = 3, A = 6, B = 4
 * Output: 8
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 10^9
 * 2 <= A <= 40000
 * 2 <= B <= 40000
 */
public class NthMagicalNumber {
    public int nthMagicalNumber(int N, int A, int B) {
        int MOD = 1_000_000_007;
        int L = A / gcd(A, B) * B;
        int M = L / A + L / B - 1;
        int q = N / M, r = N % M;

        long ans = (long) q * L % MOD;
        if (r == 0)
            return (int) ans;

        int[] heads = new int[]{A, B};
        for (int i = 0; i < r - 1; ++i) {
            if (heads[0] <= heads[1])
                heads[0] += A;
            else
                heads[1] += B;
        }

        ans += Math.min(heads[0], heads[1]);
        return (int) (ans % MOD);
    }

    public int gcd(int x, int y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }
}
