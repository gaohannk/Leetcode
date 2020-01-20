package company.oracle.high;

import java.util.LinkedList;
import java.util.List;

public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        if (num1.length() == 1 && num1.charAt(0) == '0' ||
                num2.length() == 1 && num2.charAt(0) == '0') {
            return "0";
        }
        List<List<Integer>> res = new LinkedList<>();
        int maxLen = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            int sum = 0;
            int digit = 0;
            List<Integer> partial = new LinkedList<>();
            addLeadingZero(num2, i, partial);
            for (int j = num1.length() - 1; j >= 0; j--) {
                sum = carry + (num2.charAt(i) - '0') * (num1.charAt(j) - '0');
                digit = sum % 10;
                carry = sum / 10;
                //System.out.println(sum);
                partial.add(digit);
            }
            if (carry != 0) {
                partial.add(carry);
            }
            maxLen = maxLen < partial.size() ? partial.size() : maxLen;
            res.add(partial);
        }
        System.out.println(res);
        return addEachPartialResult(res, maxLen);
    }

    private static String addEachPartialResult(List<List<Integer>> res, int maxLen) {
        int start = 0;
        StringBuilder result = new StringBuilder();

        int carry = 0;
        while (start < maxLen) {
            int sum = 0;
            int digit = 0;

            for (int i = 0; i < res.size(); i++) {
                if (start < res.get(i).size()) {
                    sum += res.get(i).get(start);
                }
            }
            sum += carry;
            digit = sum % 10;
            carry = sum / 10;
            start++;
            result.append(digit);
        }
        if (carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }

    private static void addLeadingZero(String num2, int i, List<Integer> partial) {
        // add leading 0
        int cur = num2.length() - 1 - i;
        while (cur > 0) {
            partial.add(0);
            cur--;
        }
    }

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }
}
