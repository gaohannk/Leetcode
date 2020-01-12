package company.offerup.phone;

import java.util.List;

public class MaximumDistanceinArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int diff = Integer.MIN_VALUE;
        arrays.remove(0);
        for (List<Integer> list : arrays) {
            diff = Math.max(max - list.get(0), Math.max(diff, list.get(list.size() - 1) - min));
            min = Math.min(min, list.get(0));
            max = Math.max(max, list.get(list.size() - 1));
        }
        return diff;
    }
}
