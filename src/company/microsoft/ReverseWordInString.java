package company.microsoft;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Reverse words in a string, with puncs at same position. eg. "Hello world,
 * how are you?" -> "you are, how world Hello?"
 */
public class ReverseWordInString {
    public static String reverse(String s) {
        StringBuilder res = new StringBuilder();
        LinkedList<String> words = new LinkedList<>();
        HashMap<Integer, Character> map = new HashMap<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                word.append(s.charAt(i));
            } else {
                if (word.length() != 0) {
                    words.add(word.toString());
                    word = new StringBuilder();
                }
                if (s.charAt(i) != ' ') {
                    map.put(words.size(), s.charAt(i));
                }
            }
        }

        for (int i = words.size() - 1; i >= 0; i--) {
            res.append(words.get(i));
            if (map.get(words.size() - i) != null) {
                res.append(map.get(words.size() - i));
            }
            res.append(' ');

        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverse("Hello world, how are you?"));
    }
}
