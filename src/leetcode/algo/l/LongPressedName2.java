package leetcode.algo.l;

import java.util.ArrayList;
import java.util.List;

public class LongPressedName2 {
    public boolean isLongPressedName(String name, String typed) {
        Group g1 = groupify(name);
        Group g2 = groupify(typed);
        if (!g1.key.equals(g2.key))
            return false;

        for (int i = 0; i < g1.count.size(); ++i)
            if (g1.count.get(i) > g2.count.get(i))
                return false;
        return true;
    }

    public Group groupify(String S) {
        List<Character> key = new ArrayList<>();
        List<Integer> count = new ArrayList();
        int pre = 0;
        int N = S.length();
        for (int i = 0; i < N; ++i) {
            if (i == N - 1 || S.charAt(i) != S.charAt(i + 1)) { // end of group
                key.add(S.charAt(i));
                count.add(i - pre + 1);
                pre = i + 1;
            }
        }

        return new Group(key, count);
    }

    class Group {
        List<Character> key;
        List<Integer> count;

        Group( List<Character> k, List<Integer> c) {
            key = k;
            count = c;
        }
    }
}

