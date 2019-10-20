package leetcode.l;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gaohan on 6/10/18.
 */

/**
 * For every people, call a sub function dfs to compare the quiet with others, who is richer than him.
 */
public class LoudandRich2 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        HashMap<Integer, List<Integer>> richer2 = new HashMap<>();
        int res[];
        for (int i = 0; i < n; ++i) richer2.put(i, new ArrayList<Integer>());
        for (int[] v : richer) {
            richer2.get(v[1]).add(v[0]);
        }
        res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            dfs(i, quiet, res, richer2);
        }
        return res;
    }

    int dfs(int i, int[] quiet, int[] res, HashMap<Integer, List<Integer>> richer2) {
        if (res[i] >= 0) {
            return res[i];
        }
        res[i] = i;

        for (int j : richer2.get(i)) {
            if (quiet[res[i]] > quiet[dfs(j, quiet, res, richer2)]) {
                res[i] = res[j];
            }
        }
        return res[i];
    }
}
