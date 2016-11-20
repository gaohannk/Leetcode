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
public class DecodeString2 {
    public static String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ']') { // push all except ']'
                stack.push(String.valueOf(ch));
            } else {
                // concatenate string
                StringBuilder sb1 = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    sb1.insert(0, stack.pop());
                }
                // pop "["
                stack.pop();
                // generate counter
                StringBuilder sb2 = new StringBuilder();
                while (!stack.empty() && stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9') {
                    sb2.insert(0, stack.pop());
                }
                int counter = Integer.parseInt(sb2.toString());
                // generate new string
                StringBuilder sb3 = new StringBuilder();
                for (int j = 0; j < counter; j++) {
                    sb3.append(sb1.toString());
                }
                // push new string back
                stack.push(sb3.toString());
            }
        }

        // final concat
        StringBuilder ans = new StringBuilder();
        while (!stack.empty()) {
            ans.insert(0, stack.pop());
        }

        return ans.toString();

    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        String ss = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }
}
