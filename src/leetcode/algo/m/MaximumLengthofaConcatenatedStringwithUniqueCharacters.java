package leetcode.algo.m;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumLengthofaConcatenatedStringwithUniqueCharacters {
    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }
        int[] max = new int[1];
        dfs(arr, new ArrayList<>(), 0, max);
        return max[0];
    }

    public void dfs(List<String> arr, List<String> temp, int index, int[] max) {
        if (index == arr.size()) {
            int count = 0;
            for (String s : temp) {
                count += s.length();
            }
            max[0] = Math.max(max[0], count);
            return;
        }
        for (int i = index; i < arr.size(); i++) {
            temp.add(arr.get(i));
            if (isUnique(temp)) {
                dfs(arr, temp, i + 1, max);
                temp.remove(temp.size() - 1);
            } else {
                temp.remove(temp.size() - 1);
                dfs(arr, temp, i + 1, max);
            }
        }
    }

    public boolean isUnique(List<String> temp) {
        Set<Character> set = new HashSet();
        for (String s : temp) {
            for (char c : s.toCharArray()) {
                if (!set.add(c)) {
                    return false;
                }
            }
        }
        return true;
    }
}
