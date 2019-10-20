package leetcode.k;

import java.util.HashMap;

public class KdiffPairsinanArray {

    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (k == 0 && map.get(nums[i]) == 1) {
                    res++;
                    map.put(nums[i], 2);
                }
                continue;
            } else {

                if (map.containsKey(nums[i] - k)) {
                    res++;
                }
                if (map.containsKey(nums[i] + k)) {
                    res++;
                }
                map.put(nums[i], 1);
            }
        }
        return res;
    }
}
