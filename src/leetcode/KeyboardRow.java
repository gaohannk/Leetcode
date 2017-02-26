package leetcode;

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
public class KeyboardRow {
    public String[] findWords(String[] words) {
        return Stream.of(words).filter(s -> s.toLowerCase()
                .matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*"))
                .toArray(String[]::new);
    }

}
