package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 */

public class WordBreakII {

    public static List<String> wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null) {
            return null;
        }

        List<String> res = new LinkedList<>();
        List<String> path = new LinkedList<>();
        boolean canBreak[] = new boolean[s.length() + 1];

        for (int i = 0; i < s.length() + 1; i++) {
            canBreak[i] = true;
        }

        dfs(s, dict, path, res, 0, canBreak);
        return res;
    }

    public static void dfs(String s, Set<String> dict, List<String> path, List<String> ret, int index, boolean canBreak[]) {
        if (index == s.length()) {
            // 结束了。index到了末尾
            StringBuilder sb = new StringBuilder();
            for (String str : path) {
                sb.append(str + " ");
            }
            // remove the last " "
            sb.deleteCharAt(sb.length() - 1);
            ret.add(sb.toString());
            return;
        }

        // if can't break, we exit directly.
        if (!canBreak[index])
            return;

        for (int i = index; i < s.length(); i++) {
            // 注意这些索引的取值。左字符串的长度从0到len
            String left = s.substring(index, i + 1);
            if (!dict.contains(left) || !canBreak[i + 1]) {
                continue;
            }
            path.add(left);

            int beforeChange = ret.size();
            dfs(s, dict, path, ret, i + 1, canBreak);
            // 注意这些剪枝的代码. 关键在于此以减少复杂度
            if (ret.size() == beforeChange) {
                canBreak[i + 1] = false;
            }
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<>();
        dict.add("aaaa");
        dict.add("aaa");
        String s = "aaaaaaa";
        System.out.println(wordBreak(s, dict));
    }
}
