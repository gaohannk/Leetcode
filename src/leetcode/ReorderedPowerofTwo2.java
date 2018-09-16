package leetcode;

import java.util.Arrays;

/**
 * Created by gaohan on 8/4/18.
 */
public class ReorderedPowerofTwo2 {
    public boolean reorderedPowerOf2(int N) {
        int[] A = count(N);
        for (int i = 0; i < 31; ++i) {
            //int power = (int) Math.pow(2.0, (double) i);
            int power = 1 << i;
            if (Arrays.equals(A, count(power)))
                return true;
        }
        return false;
    }

    // Returns the count of digits of N
    // Eg. N = 112223334, returns [0,2,3,3,1,0,0,0,0,0]
    public int[] count(int N) {
        int[] ans = new int[10];
        while (N > 0) {
            ans[N % 10]++;
            N /= 10;
        }
        return ans;
    }
}
