package leetcode.algo.s;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayintoFibonacciSequence2 {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();
        helper(S, ans, new ArrayList<>(), -1, -1, 0);
        return ans;
    }

    public void helper(String S, List<Integer> ans, List<Integer> temp, int p1, int p2, int start) {
        if (start == S.length()) {   // base case
            if (temp.size() >= 3) {
                ans.clear();
                for (int i : temp) {
                    ans.add(i);
                }
            }
            return;
        }
        if (S.substring(start).startsWith("0")) {   // For numbers have a leading zero
            temp.add(0);
            if (p1 == -1) {
                helper(S, ans, temp, 0, p2, start + 1);
            } else if (p2 == -1) {
                helper(S, ans, temp, p1, 0, start + 1);
            } else if (p1 + p2 == 0) {
                helper(S, ans, temp, p2, 0, start + 1);
            }
            temp.remove(temp.size() - 1);
            return;
        }
        for (int i = start + 1; i <= S.length(); i++) {   // For numbers without a leading zero
            if (S.substring(start, i).length() > 10 || Long.parseLong(S.substring(start, i)) > (long) Integer.MAX_VALUE) {
                return;
            }
            int sum = Integer.parseInt(S.substring(start, i));
            temp.add(sum);
            if (p1 == -1) {
                helper(S, ans, temp, sum, p2, i);
            } else if (p2 == -1) {
                helper(S, ans, temp, p1, sum, i);
            } else if (p1 + p2 == sum) {
                helper(S, ans, temp, p2, sum, i);
            }
            temp.remove(temp.size() - 1);
        }
    }
}
