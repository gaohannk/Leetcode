package leetcode.algo.s;

public class SwapAdjacentinLRString {
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", "")))
            return false;

        int t = 0;
        for (int i = 0; i < start.length(); ++i) {
            if (start.charAt(i) == 'L') {
                while (end.charAt(t) != 'L') {
                    t++;
                }
                if (i < t) {
                    return false;
                }
                t++;
            }
        }

        t = 0;
        for (int i = 0; i < start.length(); ++i) {
            if (start.charAt(i) == 'R') {
                while (end.charAt(t) != 'R') {
                    t++;
                }
                if (i > t) {
                    return false;
                }
                t++;
            }
        }

        return true;
    }
}
