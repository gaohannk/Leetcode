package leetcode.s;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of words, we may encode it by writing a reference string S and a list of indexes A.
 * <p>
 * For example, if the list of words is ["time", "me", "bell"], we can write it as S = "time#bell#" and indexes = [0, 2, 5].
 * <p>
 * Then for each index, we will recover the word by reading from the reference string from that index until we reach a "#" character.
 * <p>
 * What is the length of the shortest reference string S possible that encodes the given words?
 * <p>
 * Example:
 * <p>
 * Input: words = ["time", "me", "bell"]
 * Output: 10
 * Explanation: S = "time#bell#" and indexes = [0, 2, 5].
 * Note:
 * <p>
 * 1 <= words.length <= 2000.
 * 1 <= words[i].length <= 7.
 * Each word has only lowercase letters.
 */
/*Intuition

If a word X is a suffix of Y, then it does not need to be considered, as the encoding of Y in the reference string will also encode X. For example, if "me" and "time" is in words, we can throw out "me" without changing the answer.

If a word Y does not have any other word X (in the list of words) that is a suffix of Y, then Y must be part of the reference string.

Thus, the goal is to remove words from the list such that no word is a suffix of another. The final answer would be sum(word.length + 1 for word in words).

Algorithm

Since a word only has up to 7 suffixes (as words[i].length <= 7), let's iterate over all of them. For each suffix, we'll try to remove it from our words list. For efficiency, we'll make words a set.
*/
public class ShortEncodingofWords {
    public int minimumLengthEncoding(String[] words) {
        //Build a set of words.
        Set<String> good = new HashSet(Arrays.asList(words));
        //Iterate on all words and remove all suffixes of every word from the set.  Finally the set will the set of all encoding words.
        for (String word : words) {
            for (int k = 1; k < word.length(); ++k)
                good.remove(word.substring(k));
        }

        int ans = 0;
        //  Iterate on the set and return sum(word's length + 1 for every word in the set)
        for (String word : good)
            ans += word.length() + 1;
        return ans;
    }
}
