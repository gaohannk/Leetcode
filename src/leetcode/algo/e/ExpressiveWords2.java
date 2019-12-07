package leetcode.algo.e;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaohan on 4/1/18.
 */

/**
 * For some word, write the head character of every group, and the count of that group. For example, for "abbcccddddaaaaa", we'll write the "key" of "abcda", and the "count" [1,2,3,4,5].
 * <p>
 * Let's see if a word is stretchy. Evidently, it needs to have the same key as S.
 * <p>
 * Now, let's say we have individual counts c1 = S.count[i] and c2 = word.count[i].
 * <p>
 * If c1 < c2, then we can't make the ith group of word equal to the ith word of S by adding characters.
 * <p>
 * If c1 >= 3, then we can add letters to the ith group of word to match the ith group of S, as the latter is extended.
 * <p>
 * Else, if c1 < 3, then we must have c2 == c1 for the ith groups of word and S to match.
 */
public class ExpressiveWords2 {
    class RLE {
        private String key;
        private List<Integer> counts;

        public RLE(String S) {
            StringBuilder sb = new StringBuilder();
            counts = new ArrayList();

            char[] ca = S.toCharArray();
            int N = ca.length;
            int prev = -1;
            for (int i = 0; i < N; ++i) {
                if (i == N - 1 || ca[i] != ca[i + 1]) {
                    sb.append(ca[i]);
                    counts.add(i - prev);
                    prev = i;
                }
            }
            key = sb.toString();
        }
    }

    public int expressiveWords(String S, String[] words) {
        RLE R = new RLE(S);
        int ans = 0;

        for (String word : words) {
            RLE R2 = new RLE(word);
            if (!R.key.equals(R2.key))
                continue;
            boolean isBreak = false;
            for (int i = 0; i < R.counts.size(); ++i) {
                int c1 = R.counts.get(i);
                int c2 = R2.counts.get(i);
                if (c1 < 3 && c1 != c2 || c1 < c2) {
                    isBreak = true;
                    break;
                }
            }
            ans = isBreak ? ans : ans + 1;
        }
        return ans;
    }
}
