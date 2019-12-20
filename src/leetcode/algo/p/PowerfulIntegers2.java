package leetcode.algo.p;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers2 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> ans = new ArrayList<>();

        int maxx = getMax(x, bound);
        int maxy = getMax(y, bound);

        for (int i = 0; i < maxx; i++) {
            for (int j = 0; j < maxy; j++) {
                double check = Math.pow(x, i) + Math.pow(y, j);
                if (check <= bound && !ans.contains((int) check))
                    ans.add((int) check);
            }
        }
        return ans;
    }

    private int getMax(int base, int bound) {
        int max = 1;
        if (base == 1)
            return max;
        for (int i = 0; i < 64; i++) {
            if (bound <= Math.pow(base, i)) {
                max = i;
                break;
            }
        }
        return max;
    }
}
