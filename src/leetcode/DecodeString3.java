package leetcode;

import java.util.Stack;

/*Given an encoded string, return it's decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

*/
public class DecodeString3 {
    static int i = 0;

    public static String decodeString(String s) {
        if (s.length() == 0) {
            return "";
        }
        return DFS(s, 0);
    }

    private static String DFS(String s, int index) {
        if (index >= s.length()) {
            return "";
        }
        StringBuilder numStr = new StringBuilder();
        StringBuilder letterStr = new StringBuilder();
        for (i = index; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                numStr.append(s.charAt(i));
            }
            if (Character.isLetter(s.charAt(i))) {
                letterStr.append(s.charAt(i));
            }
            if (s.charAt(i) == '[') {
                String str = DFS(s, i + 1);
                for (int j = 0; j < Integer.valueOf(numStr.toString()); j++) {
                    letterStr.append(str);
                }
                numStr.delete(0, numStr.length());
            } else if (s.charAt(i) == ']') {
                return letterStr.toString();
            }
        }
        return letterStr.toString();
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        String ss = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }
}
