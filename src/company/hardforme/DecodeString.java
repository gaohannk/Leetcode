package company.hardforme;

import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> stackN = new Stack<>();
        Stack<String> stackS = new Stack<>();
        int start = 0;
        String res = "";
        while (start < s.length()) {
            if (Character.isDigit(s.charAt(start))) {
                String num = s.charAt(start)+ "";
                // look one ahead, if not digit, no need to move pointer start
                while (start +1  < s.length() && Character.isDigit(s.charAt(start+1))) {
                    num += s.charAt(++start);
                }
                stackN.push(Integer.parseInt(num));
            } else if (s.charAt(start) == '[') {
                stackS.push(res);
                res = "";
            } else if (s.charAt(start) == ']') {
                int n = stackN.pop();
                String temp = stackS.pop();
                for (int i = 0; i < n; i++) {
                    temp += res;
                }
                res = temp;
            } else if (Character.isAlphabetic(s.charAt(start))){
                res += s.charAt(start);
            }
            start++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
}
