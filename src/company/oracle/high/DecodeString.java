package company.oracle.high;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> times = new Stack<Integer>();
        Stack<String> repeat = new Stack<String>();
        int cur = 0;
        while (cur < s.length()) {
            if (s.charAt(cur) == '[') {
                repeat.push("[");
                cur++;
                String str = "";
                while (cur < s.length() && s.charAt(cur) >= 'a' && s.charAt(cur) <= 'z') {
                    str += s.charAt(cur++);
                }
                repeat.push(str);
            }
            if (cur >= s.length()) {
                break;
            }
            if (s.charAt(cur) == ']') {
                cur++;
                int time = times.pop();
                String r = repeat.pop();
                String repeatStr = "";
                while (time > 0) {
                    repeatStr += r;
                    time--;
                }
                repeat.push((repeat.isEmpty() ? "" : repeat.pop()) + repeatStr);
                System.out.println(repeat.peek());

            }
            if (cur >= s.length()) {
                break;
            }
            if (Character.isDigit(s.charAt(cur))) {
                String str = "";
                while (cur < s.length() && Character.isDigit(s.charAt(cur))) {
                    str += s.charAt(cur++);
                }
                times.push(Integer.parseInt(str));
            }
            if (cur >= s.length()) {
                break;
            }
            if (Character.isAlphabetic(s.charAt(cur))) {
                String str = "";
                while (cur < s.length() && Character.isAlphabetic(s.charAt(cur))) {
                    str += s.charAt(cur++);
                }
                repeat.push(str);
            }

        }
        String res = "";
        while (!repeat.isEmpty()) {
            res = repeat.pop() + res;
        }
        return res;
    }
}
