package leetcode.algo.n;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime2 {
    public String nextClosestTime(String time) {
        int cur = 60 * Integer.parseInt(time.substring(0, 2));
        cur += Integer.parseInt(time.substring(3));
        Set<Integer> allowed = new HashSet();
        for (char c : time.toCharArray()) {
            if (c != ':') {
                allowed.add(c - '0');
            }
        }

        while (true) {
            cur = (cur + 1) % (24 * 60);
            int[] digits = new int[]{cur / 60 / 10, cur / 60 % 10, cur % 60 / 10, cur % 60 % 10};
            if (isUseNotAllowed(allowed, digits))
                continue;
            return String.format("%02d:%02d", cur / 60, cur % 60);
        }
    }

    private boolean isUseNotAllowed(Set<Integer> allowed, int[] digits) {
        for (int d : digits) {
            if (!allowed.contains(d))
                return true;
        }
        return false;
    }
}
