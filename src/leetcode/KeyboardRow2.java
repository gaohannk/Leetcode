package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * <p>
 * <p>
 * American keyboard
 * <p>
 * <p>
 * Example 1:
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * Note:
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 */
public class KeyboardRow2 {
    public String[] findWords(String[] words) {
        String[] lines = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};

        List<String> list = new LinkedList<>();
        int index = 0;
        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < lines.length; i++) {
                if (lines[i].indexOf(Character.toUpperCase(word.charAt(0))) != -1) {
                    index = i;
                    break;
                }
            }
            for (int i = 1; i < word.length(); i++) {
                if (lines[index].indexOf(Character.toUpperCase(word.charAt(i))) == -1) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                list.add(word);
        }
        return list.toArray(new String[0]);
    }
}
