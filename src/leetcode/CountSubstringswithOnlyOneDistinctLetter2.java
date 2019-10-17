package leetcode;

public class CountSubstringswithOnlyOneDistinctLetter2 {
    public int countLetters(String S) {
        if (S.length() == 0)
            return 0;

        char prev = S.charAt(0);
        int rep = 1, count = 0;
        for (int i = 1; i <= S.length(); i++) {
            if (S.charAt(i) == prev) {
                rep++;
                continue;
            }
            count += rep * (rep + 1) / 2;
            rep = 1;
            prev = S.charAt(i);
        }
        count += rep * (rep + 1) / 2;
        return count;
    }
}
