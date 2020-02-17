package leetcode.algo;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 *
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 *
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
// TODO wrong
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }
        StringBuilder str = new StringBuilder(num);

        int i = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(str.charAt(0) - '0');
        while (k > 0 && i < str.length()) {
            boolean increase = true;
            while (k > 0 && i < str.length() && str.charAt(i) != '0') {
                System.out.println(stack);
                System.out.println(k);

                if (!stack.isEmpty() && str.charAt(i) - '0' < stack.peek()) {
                    stack.pop();
                    stack.push(str.charAt(i) - '0');
                    increase = false;
                    k--;
                } else if(!stack.isEmpty() && str.charAt(i) - '0' > stack.peek()){
                    if (increase) {
                        stack.push(str.charAt(i) - '0');
                    } else {
                        k--;
                    }
                } else {
                    stack.push(str.charAt(i) - '0');
                }
                i++;
            }
            while (!stack.isEmpty() && k > 0) {
                stack.pop();
                k--;
            }
            if (i<str.length() && str.charAt(i) == '0') {
                stack.push(str.charAt(i) - '0');
                i++;
            }
        }
        while (i < str.length()) {
            stack.push(str.charAt(i) - '0');
            i++;
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return removeLeadingZero(res.reverse());
    }

    private String removeLeadingZero(StringBuilder res) {
        int i = 0;
        while (i < res.length()) {
            if (res.charAt(i) != '0') {
                return res.substring(i);
            }
            i++;
        }
        return "0";
    }
}
