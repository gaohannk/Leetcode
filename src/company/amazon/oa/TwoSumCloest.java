package company.amazon.oa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * // 7. 卡车装箱 (TWO SUM) 和 Two Song 一样
 * // e.g. truck capacity - 90 / reserved capacity - 30 / package capacities - [10, 25, 35, 60]
 * // 要求返回 [1, 2] (25和35的索引)
 */
// Leetcode two sum return index
public class TwoSumCloest {

    public List<Integer> solution(int trunkSpace, List<Integer> itemSpaces) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < itemSpaces.size(); i++) {
            Integer index = map.get(trunkSpace - itemSpaces.get(i));
            if (index != null) {
                res.add(index);
                res.add(i);
                break;
            } else {
                map.put(itemSpaces.get(i), i);
            }
        }
        return res;
    }
}
