package leetcode;

/**
 * Created by gaohan on 8/4/18.
 * Complexity Analysis

 Time Complexity: O(\log N)O(logN). Note that \log NlogN is the number of digits in the binary representation of NN.

 Space Complexity: O(1)O(1).
 */
public class BinaryGap2 {
    public int binaryGap(int N) {
        int last = -1, ans = 0;
        for (int i = 0; i < 32; ++i)
            if (((N >> i) & 1) > 0) {
                if (last >= 0)
                    ans = Math.max(ans, i - last);
                last = i;
            }

        return ans;
    }
}
