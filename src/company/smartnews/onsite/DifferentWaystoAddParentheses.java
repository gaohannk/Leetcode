package company.smartnews.onsite;

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
public class DifferentWaystoAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        String num[] = input.split("[+,-,*]");
        char operators[] = input.replaceAll("[0-9]", "").toCharArray();
        List<Integer>[][] dp = new LinkedList[num.length][num.length];
        return helper(num, operators, 0, num.length - 1, dp);
    }

    private List<Integer> helper(String[] num, char[] operators, int start, int end, List<Integer>[][] dp) {
        if (dp[start][end] != null)
            return dp[start][end];

        if (end == start) {
            List<Integer> ans = new ArrayList<Integer>();
            ans.add(Integer.parseInt(num[start]));
            return ans;
        }

        List<Integer> ans = new LinkedList<>();

        for (int k = start; k < end; k++) {
            for (int x : helper(num, operators, start, k, dp)) {
                for (int y : helper(num, operators, k + 1, end, dp)) {
                    ans.add(mathOperations(x, y, operators[k]));
                }
            }
        }

        dp[start][end] = ans;
        return dp[start][end];
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
