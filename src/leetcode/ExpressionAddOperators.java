package leetcode;

import java.util.ArrayList;
import java.util.List;

/* Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 * Examples: 
 * "123", 6 -> ["1+2+3", "1*2*3"] 
 * "232", 8 -> ["2*3+2", "2+3*2"]
 * "105", 5 -> ["1*0+5","10-5"]
 * "00", 0 -> ["0+0", "0-0", "0*0"]
 * "3456237490", 9191 -> []
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= num.length(); i++) {
            if (i >= 2 && num.charAt(0) == '0')
                continue;
            helper(res, num.substring(0, i), num.substring(i), 0, Integer.parseInt(num.substring(0, i)), target, false);
        }

        return res;
    }

    private void helper(List<String> res, String exp, String num, int value, int number, int target, boolean sign) {
        int sum = sign ? value + number : value - number;
        if (num.length() == 0 && value == target) {
            res.add(exp);
            return;
        }
        for (int i = 1; i < num.length(); i++) {
            int current = Integer.parseInt(num.substring(0, i));
            exp += "+" + num.substring(0, i);
            helper(res, exp, num.substring(i), sum, current, target, true);
            exp = exp.substring(0, exp.length() - i - 1);
            exp += "-" + num.substring(0, i);
            helper(res, exp, num.substring(i), sum, current, target, false);
            exp = exp.substring(0, exp.length() - i - 1);
            exp += "*" + num.substring(0, i);
            helper(res, exp, num.substring(i), value, current * number, target, sign);
            exp = exp.substring(0, exp.length() - i - 1);
        }
        return;
    }
}
