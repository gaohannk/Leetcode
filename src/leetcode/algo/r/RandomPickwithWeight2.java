package leetcode.algo.r;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by gaohan on 7/27/18.
 */
public class RandomPickwithWeight2 {
    class Solution {

        List<Integer> preSum = new ArrayList<>();
        int total = 0;
        Random rand = new Random();

        public Solution(int[] w) {
            for (int x : w) {
                total += x;
                preSum.add(total);
            }
        }

        public int pickIndex() {
            int target = rand.nextInt(total);

            int low = 0;
            int high = preSum.size() - 1;
            while (low != high) {
                int mid = (low + high) / 2;
                if (target >= preSum.get(mid)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }
}
