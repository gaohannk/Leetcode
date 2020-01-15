package company.oracle.high;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> res = new ArrayList<>();
        int sum = Integer.MAX_VALUE;

        for (int i = 0; i < list2.length; i++) {
            String restaurant = list2[i];
            if (map.containsKey(restaurant)) {
                int index = map.get(restaurant);
                if (index + i < sum) {
                    res.clear();
                    sum = index + i;
                    res.add(restaurant);
                } else if (index + i == sum) {
                    res.add(restaurant);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
