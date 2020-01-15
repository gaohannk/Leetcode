package leetcode.algo.m;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// 0(n^2)
public class MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (!map.containsKey(i + j))
                        map.put(i + j, new ArrayList<String>());
                    map.get(i + j).add(list1[i]);
                }
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (int sum : map.keySet()) {
            minSum = Math.min(minSum, sum);
        }
        String[] res = new String[map.get(minSum).size()];
        return map.get(minSum).toArray(res);
    }
}
