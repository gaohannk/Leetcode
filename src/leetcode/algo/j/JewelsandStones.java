package leetcode.algo.j;

import java.util.HashSet;

public class JewelsandStones {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> hs = new HashSet<>();
        for (char c : J.toCharArray())
            hs.add(c);

        int cnt = 0;
        for (char c : S.toCharArray()) {
            if (hs.contains(c))
                cnt++;
        }
        return cnt;
    }

    public int numJewelsInStones2(String J, String S) {
        int[] hash = new int[256];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i)]++;
        }
        int count = 0;
        for (int i = 0; i < J.length(); i++) {
            count += hash[J.charAt(i)];
        }
        return count;

    }
}
