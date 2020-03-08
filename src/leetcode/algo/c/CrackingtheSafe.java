package leetcode.algo.c;

import java.util.*;

/**
 * There is a box protected by a password. The password is a sequence of n digits where each digit can be one of the first k digits 0, 1, ..., k-1.
 *
 * While entering a password, the last n digits entered will automatically be matched against the correct password.
 *
 * For example, assuming the correct password is "345", if you type "012345", the box will open because the correct password matches the suffix of the entered password.
 *
 * Return any password of minimum length that is guaranteed to open the box at some point of entering it.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1, k = 2
 * Output: "01"
 * Note: "10" will be accepted too.
 * Example 2:
 *
 * Input: n = 2, k = 2
 * Output: "00110"
 * Note: "01100", "10011", "11001" will be accepted too.
 *
 *
 * Note:
 *
 * n will be in the range [1, 4].
 * k will be in the range [1, 10].
 * k^n will be at most 4096.
 */
public class CrackingtheSafe {
    public String crackSafe(int n, int k) {
        String root = "0".repeat(n);
        return helper(k, n, new HashSet<>(), root);
    }

    private String helper(int k, int n, Set<String> visited, String cur) {
        String lastPwd = cur.substring(cur.length() - n);
        visited.add(lastPwd);

        if (visited.size() == Math.pow(k, n)) {
            return cur;
        }

        String common = lastPwd.substring(1);
        for (int i = 0; i < k; i++) {
            if (visited.contains(common + i)) {
                continue;
            }
            String result = helper(k, n, visited, cur + i);
            if (!result.equals("")) {
                return result;
            }
        }

        visited.remove(lastPwd);

        return "";
    }
}
