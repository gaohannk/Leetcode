package leetcode.algo.g;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupthePeopleGiventheGroupSizeTheyBelongTo {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList();
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            groups.putIfAbsent(groupSizes[i], new ArrayList());
            groups.get(groupSizes[i]).add(i);

        }
        for (int size : groups.keySet()) {
            for (int i = 0; i < groups.get(size).size(); i += size) {
                res.add(groups.get(size).subList(i, i + size));
            }
        }
        return res;
    }
}
