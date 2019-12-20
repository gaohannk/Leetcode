package leetcode.algo.m;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumLengthofaConcatenatedStringwithUniqueCharacters2 {
    private int maxLen;

    private boolean isUniq(String s) {
        HashSet<String> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(String.valueOf(c)))
                return false;
            set.add(String.valueOf(c));
        }
        return true;
    }

    private void explore(List<String> arr, StringBuilder sb, int idx) {
        int len = sb.length();
        maxLen = Math.max(maxLen, len);
        if (idx == arr.size())
            return;
        for (int i = idx; i < arr.size(); i++) {
            sb.append(arr.get(i));
            if (isUniq(sb.toString())) {
                explore(arr, sb, i + 1);
            }
            sb.setLength(len);
        }
    }

    public int maxLength(List<String> arr) {
        maxLen = Integer.MIN_VALUE;
        explore(arr, new StringBuilder(), 0);
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
