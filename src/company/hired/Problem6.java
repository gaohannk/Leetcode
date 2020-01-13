package company.hired;

import java.util.Stack;

public class Problem6 {
    public static String solution(String angles) {
        // Type your solution here
        int i = 0;
        StringBuilder res = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        while (i < angles.length()) {
            if (angles.charAt(i) == '<') {
                stack.push(angles.charAt(i));
            } else {
                if (!stack.isEmpty() && stack.peek() == '<') {
                    stack.pop();

                } else {
                    stack.push(angles.charAt(i));
                }
            }
            res.append(angles.charAt(i));
            i++;
        }
        while (!stack.isEmpty() && stack.peek() == '<') {
            stack.pop();
            res.append('>');
        }
        while (!stack.isEmpty() && stack.peek() == '>') {
            stack.pop();
            res.insert(0, '<');
        }
        return res.toString();
    }

    public static void main(String[] args) {
//        String angels = "><<><";
        String angels = "<<<>>>>";
        System.out.println(solution(angels));
    }
}
