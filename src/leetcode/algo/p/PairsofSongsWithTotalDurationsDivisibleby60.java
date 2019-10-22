package leetcode.algo.p;

import java.util.HashMap;
import java.util.Map;

public class PairsofSongsWithTotalDurationsDivisibleby60 {
    public int numPairsDivisibleBy60(int[] times) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int time : times) {
            int t = time % 60;
            if (t == 0)
                count += map.getOrDefault(t, 0);
            else
                count += map.getOrDefault(60 - t, 0);
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        return count;
    }
}
