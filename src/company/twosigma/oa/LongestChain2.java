package company.twosigma.oa;

import java.util.*;

/**
 * Problem Statement
 * You are given a library with n words (w[0], w[1], ...,w[n-1]). You choose a word from it, and in each step, remove one letter from this word only if doing so yields another word in the library. What is the longest possible chain of these removal steps?
 *
 * Constraints:
 * 1 <= n <= 50000
 * 1 <= the length of each string in w <= 50
 * Each string is composed of lowercase ascii letters only
 * The function should take in an array of strings w as its argument and should return a single integer representing the length of the longest chain of character removals possible.
 *
 * Example input/output
 * a
 * b
 * ba
 * bca
 * bda
 * bdca
 *
 * Calling the function on the input above should output 4. The longest possible chain is "bdca" -> "bca" -> "ba" -> "a".
 */
// 1048 DP
public class LongestChain2 {

    public int longestStrChain(String[] words) {

        if (words == null || words.length == 0) return 0;
        int res = 0;
        Arrays.sort(words, (a, b) -> a.length() - b.length());  // Sort the words based on their lengths
        HashMap<String, Integer> map = new HashMap();       //Stores each word and length of its max chain.

        for (String w : words) {                             //From shortest word to longest word
            if (map.containsKey(w)) {
                continue;                //Already processed
            }
            map.put(w, 1);                                  //Each word is atleast 1 chain long
            for (int i = 0; i < w.length(); i++) {               //Form next word removing 1 char each time for each w
                StringBuilder sb = new StringBuilder(w);
                String next = sb.deleteCharAt(i).toString();
                if (map.containsKey(next) && map.get(next) + 1 > map.get(w)){
                    map.put(w, map.get(next) + 1);            //If the new chain is longer, update the map

                }
            }
            res = Math.max(res, map.get(w));                //Store max length of all chains
        }
        return res;
    }
}
