package leetcode.algo;

import java.util.*;

public class SplitArrayintoConsecutiveSubsequences {
    public static boolean isPossible(int[] nums) {
        // key: nums[i], value: length of sequence ending with nums[i]
        // PriorityQueue value : # in this sequence end with key
        Map<Integer, PriorityQueue<Integer>> map = new HashMap();

        for (int num : nums) {
            int last = num - 1;
            if (!map.containsKey(last) || map.get(last).size() == 0) {
                if (map.get(num) == null) {
                    map.put(num, new PriorityQueue<>());
                }
                map.get(num).offer(1);
            } else {
                // poll a shortest sequence
                int seqCount = map.get(last).poll();
                if (map.get(num) == null) {
                    map.put(num, new PriorityQueue<>());
                }
                map.get(num).offer(seqCount + 1);
            }
        }
        System.out.println(map);
        for (Integer key : map.keySet()) {
            for (int val : map.get(key)) {
                if (val < 3) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3, 4, 4, 5, 5};
        System.out.println(isPossible(nums));
    }
}
