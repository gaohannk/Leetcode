package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        backtrack(res, s.toCharArray(), 0);
        return res;
    }

    private void backtrack(List<String> res, char[] ch, int i) {
        if (i == ch.length) {
            res.add(new String(ch));
            return;
        }
        backtrack(res, ch, i + 1);
        if (!Character.isLetter(ch[i]))
            return;
        char old = ch[i];
        ch[i] = Character.isLowerCase(ch[i]) ? Character.toUpperCase(ch[i]) : Character.toLowerCase(ch[i]);
        backtrack(res, ch, i + 1);
        ch[i] = old;
    }
}
