package company.microsoft.oa;

import java.util.*;

/**
 * Given a string s consisting of n lowercase letters, you have to delete the minimum number of characters from s so that every letter in s appears a unique number of times. We only care about the occurrences of letters that appear at least once in result.
 *
 * Example 1:
 *
 * Input: "eeeeffff"
 * Output: 1
 * Explanation:
 * We can delete one occurence of 'e' or one occurence of 'f'. Then one letter will occur four times and the other three times.
 * Example 2:
 *
 * Input: "aabbffddeaee"
 * Output: 6
 * Explanation:
 * For example, we can delete all occurences of 'e' and 'f' and one occurence of 'd' to obtain the word "aabbda".
 * Note that both 'e' and 'f' will occur zero times in the new word, but that's fine, since we only care about the letter that appear at least once.
 * Example 3:
 *
 * Input: "llll"
 * Output: 0
 * Explanation:
 * There is no need to delete any character.
 * Example 4:
 *
 * Input: "example"
 * Output: 4
 */
public class MinDeletionstoMakeFrequencyofEachLetterUnique {
    public int minDeletions(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Integer> freq = new ArrayList<>(countMap.values());
        Collections.sort(freq, Collections.reverseOrder());

        int deleted = 0;
        Set<Integer> uniqueFreq = new HashSet<>();

        for (int n : freq) {
            if (!uniqueFreq.contains(n)) {
                uniqueFreq.add(n);
                continue;
            }
            while (uniqueFreq.contains(n)) {
                n--;
                deleted++;
            }
            if (n != 0) {
                uniqueFreq.add(n);
            }
        }
        return deleted;
    }
}
