package leetcode.algo.l;

import java.util.HashMap;
import java.util.Map;

public class LargestUniqueNumber2 {
    public int largestUniqueNumber(int[] A) {
        int[] cnt = new int[1001];
        for (int value : A) {
            cnt[value]++;
        }
        for (int x = 1000; x > 0; x--) {
            if (cnt[x] == 1) {
                return x;
            }
        }
        return -1;
    }
}
