package leetcode;

import java.util.*;

/**
 * Given a list of phrases, generate a list of Before and After puzzles.
 *
 * A phrase is a string that consists of lowercase English letters and spaces only. No space appears in the start or the end of a phrase. There are no consecutive spaces in a phrase.
 *
 * Before and After puzzles are phrases that are formed by merging two phrases where the last word of the first phrase is the same as the first word of the second phrase.
 *
 * Return the Before and After puzzles that can be formed by every two phrases phrases[i] and phrases[j] where i != j. Note that the order of matching two phrases matters, we want to consider both orders.
 *
 * You should return a list of distinct strings sorted lexicographically.
 *
 *
 *
 * Example 1:
 *
 * Input: phrases = ["writing code","code rocks"]
 * Output: ["writing code rocks"]
 *
 * Example 2:
 *
 * Input: phrases = ["mission statement",
 *                   "a quick bite to eat",
 *                   "a chip off the old block",
 *                   "chocolate bar",
 *                   "mission impossible",
 *                   "a man on a mission",
 *                   "block party",
 *                   "eat my words",
 *                   "bar of soap"]
 * Output: ["a chip off the old block party",
 *          "a man on a mission impossible",
 *          "a man on a mission statement",
 *          "a quick bite to eat my words",
 *          "chocolate bar of soap"]
 *
 * Example 3:
 *
 * Input: phrases = ["a","b","a"]
 * Output: ["a"]
 *
 *
 *
 * Constraints:
 *
 *     1 <= phrases.length <= 100
 *     1 <= phrases[i].length <= 100
 */
public class BeforeandAfterPuzzle2 {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        //Hash map to store head of strings and their respective indices as list
        HashMap<String, ArrayList<Integer>> afterPhrasesMap = new HashMap<String, ArrayList<Integer>>();
        for (int index = 0; index < phrases.length; index++) {
            String[] parts = phrases[index].split(" ");
            afterPhrasesMap.putIfAbsent(parts[0], new ArrayList<>());
            afterPhrasesMap.get(parts[0]).add(index);
        }

        //Tree set to avoid duplicates and keep the result sorted
        TreeSet<String> result = new TreeSet<String>();
        for (int i = 0; i < phrases.length; i++) {
            String[] parts = phrases[i].split(" ");
            //use StringBuffer to store the current phrase without last word
            StringBuffer sb = new StringBuffer(phrases[i]);
            sb.delete(sb.length() - parts[parts.length - 1].length(), sb.length());//remove the last word

            //retrieve the string indices which starts with the current phrase's ending word from the Map
            ArrayList<Integer> afterPhrases = afterPhrasesMap.getOrDefault(parts[parts.length - 1], null);
            if (afterPhrases != null) {
                //concatenating with current phrase
                for (int tempPhraseIndex : afterPhrases) {
                    if (tempPhraseIndex != i) //if both words are not same
                    {
                        sb.append(phrases[tempPhraseIndex]);
                        result.add(sb.toString());
                        sb.delete(sb.length() - phrases[tempPhraseIndex].length(), sb.length());//reset string buffer to current phrase by deleting the after phrase
                    }
                }
            }
        }
        //create array list which takes TreeSet as input
        List<String> res = new ArrayList<String>(result);
        return res;
    }

}
