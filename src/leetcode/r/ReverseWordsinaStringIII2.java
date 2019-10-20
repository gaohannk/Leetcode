package leetcode.r;

import java.util.ArrayList;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWordsinaStringIII2 {
    public String reverseWords(String s) {
        String words[] = split(s);
        StringBuilder res = new StringBuilder();
        for (String word : words)
            res.append(reverse(word) + " ");
        return res.toString().trim();
    }

    public String[] split(String s) {
        ArrayList<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                words.add(word.toString());
                word = new StringBuilder();
            } else
                word.append(s.charAt(i));
        }
        words.add(word.toString());
        return words.toArray(new String[words.size()]);
    }

    public String reverse(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            res.insert(0, s.charAt(i));
        return res.toString();
    }
}
