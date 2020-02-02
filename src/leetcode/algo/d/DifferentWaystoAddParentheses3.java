package leetcode.algo.d;

import java.util.ArrayList;
import java.util.List;

/* Given a string of numbers and operators, return all possible results from computing all the different possible ways
 * to group numbers and operators. The valid operators are +, - and *.
 * Example 1
 * Input: "2-1-1".
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 * Example 2
 * Input: "2*3-4*5"
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 */
// No DP
public class DifferentWaystoAddParentheses3 {
    public static List<Integer> diffWaysToCompute(String input) {
        return helper(0, input.length() - 1, input);
    }

    private static List<Integer> helper(int i, int j, String input) {
        if (input.substring(i, j + 1).indexOf("-") == -1
                && input.substring(i, j + 1).indexOf("+") == -1
                && input.substring(i, j + 1).indexOf("*") == -1) {
            List<Integer> ans = new ArrayList<>();
            ans.add(Integer.parseInt(input.substring(i, j + 1)));
            return ans;
        }

        List<Integer> ans = new ArrayList<Integer>();

        for (int k = i; k < j; k++) {
            if (input.charAt(k) == '-' || input.charAt(k) == '+' || input.charAt(k) == '*') {
                List<Integer> leftResult = helper(i, k - 1, input);
                List<Integer> rightResult = helper(k + 1, j, input);
                for (Integer x : leftResult) {
                    for (Integer y : rightResult) {
                        ans.add(mathOperations(x, y, input.charAt(k)));
                    }
                }
            }
        }
        return ans;
    }

    public static int mathOperations(int x, int y, char c) {
        if (c == '+')
            return x + y;
        if (c == '-')
            return x - y;
        if (c == '*')
            return x * y;
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2*3-4*5"));
    }
}
