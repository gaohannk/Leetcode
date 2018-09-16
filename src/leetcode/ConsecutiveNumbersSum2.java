package leetcode;

/**
 * Created by gaohan on 5/31/18.
 */

public class ConsecutiveNumbersSum2 {
    public int consecutiveNumbersSum(int N) {
        // 2N = k(2x + k + 1)
        int ans = 0;
        for (int k = 1; k <= 2*N; ++k)
            if (2 * N % k == 0) {
                int y = 2 * N / k - k - 1;
                if (y % 2 == 0 && y >= 0)
                    ans++;
            }
        return ans;
    }
}
