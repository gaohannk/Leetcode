package leetcode.algo.g;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// No need hashmap, use array which has index as groupSize
public class GroupthePeopleGiventheGroupSizeTheyBelongTo3 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        int n = groupSizes.length;

        List<Integer>[] arr = new List[n + 1];
        for (int i = 0; i < n; i++) {
            if (arr[groupSizes[i]] == null) {
                arr[groupSizes[i]] = new ArrayList<>();
            }
            arr[groupSizes[i]].add(i);
        }
        for (int i = 1; i < n + 1; i++) {
            if (arr[i] != null && arr[i].size() >= i) {
                for (int k = 0; k < arr[i].size(); k += i) {
                    List<Integer> list = arr[i].subList(k, k + i);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
