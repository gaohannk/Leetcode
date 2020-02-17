package leetcode.algo.s;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a list of pairs of equivalent words synonyms and a sentence text, Return all possible synonymous sentences sorted lexicographically.
 *
 *
 * Example 1:
 *
 * Input:
 * synonyms = [["happy","joy"],["sad","sorrow"],["joy","cheerful"]],
 * text = "I am happy today but was sad yesterday"
 * Output:
 * ["I am cheerful today but was sad yesterday",
 * ​​​​​​​"I am cheerful today but was sorrow yesterday",
 * "I am happy today but was sad yesterday",
 * "I am happy today but was sorrow yesterday",
 * "I am joy today but was sad yesterday",
 * "I am joy today but was sorrow yesterday"]
 *
 *
 * Constraints:
 *
 * 0 <= synonyms.length <= 10
 * synonyms[i].length == 2
 * synonyms[0] != synonyms[1]
 * All words consist of at most 10 English letters only.
 * text is a single space separated sentence of at most 10 words.
 */
public class SynonymousSentences {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        List<String[]> res = new LinkedList<>();
        List<Set<String>> setList = new LinkedList<>();
        boolean[] visited = new boolean[synonyms.size()];
        for (int i = 0; i < synonyms.size(); i++) {
            if (!visited[i]) {
                Set<String> set = new HashSet<>();
                dfs(synonyms, set, visited, i);
                setList.add(set);
            }
        }

        String[] sentence = text.split(" ");
        res.add(sentence);
        helper(0, res, setList);
        List<String> ret = res.stream().map(arr -> Arrays.stream(arr).reduce((a, b) -> a + " " + b).get()).collect(Collectors.toList());
        Collections.sort(ret);
        return ret;
    }

    private void helper(int cur, List<String[]> res, List<Set<String>> setList) {
        if (cur == res.get(0).length) {
            return;
        }
        String curWord = res.get(0)[cur];
        for (Set<String> set : setList) {
            if (set.contains(curWord)) {
                List<String[]> newRes = new LinkedList<>();
                for (String[] ss : res) {
                    for (String s : set) {
                        if (!ss[cur].equals(s)) {
                            String[] clone = ss.clone();
                            clone[cur] = s;
                            newRes.add(clone);
                        }
                    }
                }
                res.addAll(newRes);
            }
        }

        helper(cur + 1, res, setList);
    }

    private void dfs(List<List<String>> synonyms, Set<String> set, boolean[] visited, int cur) {
        if (visited[cur]) {
            return;
        }
        visited[cur] = true;
        set.addAll(synonyms.get(cur));
        for (int i = 0; i < synonyms.size(); i++) {
            if (!visited[i] && set.contains(synonyms.get(i).get(0)) || set.contains(synonyms.get(i).get(1))) {
                dfs(synonyms, set, visited, i);
            }
        }
    }
}
