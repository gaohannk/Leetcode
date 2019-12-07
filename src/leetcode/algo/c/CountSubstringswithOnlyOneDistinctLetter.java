package leetcode.algo.c;

public class CountSubstringswithOnlyOneDistinctLetter {
    public int countLetters(String S) {
        int ans = 0, repeat = 1;
        for (int i = 1; i < S.length(); ++i) {
            if (S.charAt(i) != S.charAt(i - 1)) { // previous char consectively occurs 'repeat' times.
                ans += repeat * (repeat + 1) / 2;
                repeat = 0;
            }
            repeat++;
        }
        return ans + repeat * (repeat + 1) / 2;
    }
}
