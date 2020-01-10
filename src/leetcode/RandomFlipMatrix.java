package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomFlipMatrix {
    Map<Integer, Integer> V = new HashMap<>();
    int nr, nc, rem;
    Random rand = new Random();

    public RandomFlipMatrix(int n_rows, int n_cols) {
        nr = n_rows;
        nc = n_cols;
        rem = nr * nc;
    }

    public int[] flip() {
        int r = rand.nextInt(rem--);
        int x = V.getOrDefault(r, r);
        V.put(r, V.getOrDefault(rem, rem));
        return new int[]{x / nc, x % nc};
    }

    public void reset() {
        V.clear();
        rem = nr * nc;
    }
}
