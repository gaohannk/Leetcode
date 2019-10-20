package leetcode.c;

/**
 * Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s. For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.
 * <p>
 * Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: queries = ["cbd"], words = ["zaaaz"]
 * Output: [1]
 * Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
 * Example 2:
 * <p>
 * Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * Output: [1,2]
 * Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j], words[i][j] are English lowercase letters.
 */
public class CompareStringsbyFrequencyoftheSmallestCharacter {
    private int getFsc(String s) {
        char minChar = 'z';
        int frequency = 0;

        for (char c : s.toCharArray()) {
            if (c < minChar) {
                minChar = c;
                frequency = 1;
            } else if (c == minChar) {
                frequency++;
            }
        }

        return frequency;
    }

    private int getAnswerFromArray(int[] wordsFreqiencies, int qFsc) {
        int ans = 0;

        for (int i = qFsc + 1; i < wordsFreqiencies.length; i++) {
            ans += wordsFreqiencies[i];
        }

        return ans;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] answers = new int[queries.length];
        // The times of each frequency appears
        int[] wordsFrequencies = new int[11];

        for (String word : words) {
            wordsFrequencies[getFsc(word)]++;
        }

        for (int i = 0; i < queries.length; i++) {
            int fsc = getFsc(queries[i]);
            answers[i] = getAnswerFromArray(wordsFrequencies, fsc);
        }

        return answers;
    }
}
