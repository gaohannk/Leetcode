package leetcode.algo.g;

import java.util.*;

public class GroupthePeopleGiventheGroupSizeTheyBelongTo2 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList();
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = groups.putIfAbsent(groupSizes[i], new ArrayList());
            list.add(i);
            if (list.size() == groupSizes[i]) {
                res.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return res;
    }
}
