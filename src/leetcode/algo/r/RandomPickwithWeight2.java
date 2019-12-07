package leetcode.algo.r;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by gaohan on 7/27/18.
 */
public class RandomPickwithWeight2 {
    class Solution {

        List<Integer> psum = new ArrayList<>();
        int tot = 0;
        Random rand = new Random();

        public Solution(int[] w) {
            for (int x : w) {
                tot += x;
                psum.add(tot);
            }
        }

        public int pickIndex() {
            int targ = rand.nextInt(tot);

            int lo = 0;
            int hi = psum.size() - 1;
            while (lo != hi) {
                int mid = (lo + hi) / 2;
                if (targ >= psum.get(mid)) lo = mid + 1;
                else hi = mid;
            }
            return lo;
        }
    }
}
