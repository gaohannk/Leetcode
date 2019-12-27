package leetcode.algo.m;

import java.util.List;

public class MaximumDistanceinArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int diff = Integer.MIN_VALUE;
        for (int i = 1; i < arrays.size(); i++) {
            int large = arrays.get(i).get(arrays.get(i).size() - 1);
            int small = arrays.get(i).get(0);
            diff = Math.max(Math.max(diff, large - min), max - small);
            min = Math.min(min, small);
            max = Math.max(max, large);
        }
        return diff;
    }
}
