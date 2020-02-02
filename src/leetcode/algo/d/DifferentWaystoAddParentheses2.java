package leetcode.algo.d;

import java.util.ArrayList;
import java.util.LinkedList;
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
public class DifferentWaystoAddParentheses2 {
    public List<Integer> diffWaysToCompute(String input) {
        String num[]= input.split("[*,+,-]");
        char operators[]= input.replaceAll("[0-9]","").toCharArray();
        return helper(num, operators, 0, num.length - 1);
    }

    private List<Integer> helper(String[] num, char[] operators, int i, int j) {
        if (j == i) {
            List<Integer> ans = new ArrayList<Integer>();
            ans.add(Integer.parseInt(num[i]));
            return ans;
        }

        List<Integer> ans = new ArrayList<Integer>();

        for (int k = i; k < j; k++) {
            for (int x : helper(num, operators, i, k)) {
                for (int y : helper(num, operators, k + 1, j)) {
                    ans.add(mathOperations(x, y, operators[k]));
                }
            }
        }
        return ans;
    }

    public int mathOperations(int x, int y, char c) {
        if (c == '+')
            return x + y;
        if (c == '-')
            return x - y;
        if (c == '*')
            return x * y;

        return 0;
    }
}
