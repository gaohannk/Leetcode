package leetcode.e;

/**
 * Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".  Here, we have groups, of adjacent letters that are all the same character, and adjacent characters to the group are different.  A group is extended if that group is length 3 or more, so "e" and "o" would be extended in the first example, and "i" would be extended in the second example.  As another example, the groups of "abbcccaaaa" would be "a", "bb", "ccc", and "aaaa"; and "ccc" and "aaaa" are the extended groups of that string.
 * <p>
 * For some given string S, a query word is stretchy if it can be made to be equal to S by extending some groups.  Formally, we are allowed to repeatedly choose a group (as defined above) of characters c, and add some number of the same character c to it so that the length of the group is 3 or more.  Note that we cannot extend a group of size one like "h" to a group of size two like "hh" - all extensions must leave the group extended - ie., at least 3 characters long.
 * <p>
 * Given a list of query words, return the number of words that are stretchy.
 * <p>
 * Example:
 * Input:
 * S = "heeellooo"
 * words = ["hello", "hi", "helo"]
 * Output: 1
 * Explanation:
 * We can extend "e" and "o" in the word "hello" to get "heeellooo".
 * We can't extend "helo" to get "heeellooo" because the group "ll" is not extended.
 * Notes:
 * <p>
 * 0 <= len(S) <= 100.
 * 0 <= len(words) <= 100.
 * 0 <= len(words[i]) <= 100.
 * S and all words in words consist only of lowercase letters
 */
public class ExpressiveWords {
    public static int expressiveWords(String S, String[] words) {
        int res = 0;
        for (String word : words) {
            int i = 0, j = 0;
            boolean flag = false;
            while (i < S.length() && j < word.length()) {
                int count = 1, count2 = 1;
                char schar = S.charAt(i);
                char wordChar = word.charAt(j);
                if (schar != wordChar) {
                    flag = true;
                    break;
                }
                while ((i + 1 < S.length() && S.charAt(i) == S.charAt(i + 1))) {
                    count++;
                    i++;
                }
                i++;
                while ((j + 1 < word.length() && word.charAt(j) == word.charAt(j + 1))) {
                    count2++;
                    j++;
                }
                j++;
                if (count == 1 && count2 == 1) {
                    continue;
                } else if (count == 2 && count2 == 2) {
                    continue;
                } else if (count > 2 && count2 <= count) {
                    continue;
                } else {
                    flag = true;
                    break;
                }
            }
            // No break in the middle and reach end of both word eg "abcde", "abc"
            if (!flag && i == S.length() && j == word.length()) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"dinnssoo", "ddinso", "ddiinnso", "ddiinnssoo", "ddiinso", "dinsoo", "ddiinsso", "dinssoo", "dinso"};
        System.out.print(expressiveWords("dddiiiinnssssssoooo", words));
    }
}
