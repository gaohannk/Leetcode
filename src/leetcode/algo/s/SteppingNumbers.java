package leetcode.algo.s;

import java.util.LinkedList;
import java.util.List;

/**
 * A Stepping Number is an integer such that all of its adjacent digits have an absolute difference of exactly 1. For example, 321 is a Stepping Number while 421 is not.
 * <p>
 * Given two integers low and high, find and return a sorted list of all the Stepping Numbers in the range [low, high] inclusive.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: low = 0, high = 21
 * Output: [0,1,2,3,4,5,6,7,8,9,10,12,21]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= low <= high <= 2 * 10^9
 */
public class SteppingNumbers {
    public static List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> cur = new LinkedList<>();
        for (int i = 0; i <= 9; i++) {
            cur.add(i);
        }
        List<Integer> res = new LinkedList<>();
        addNuminRange(low, high, cur, res);
        for (int i = 0; i < 9; i++) {
            cur = helper(cur, low, high);
            addNuminRange(low, high, cur, res);
        }
        return res;
    }

    public static void addNuminRange(int low, int high, List<Integer> cur, List<Integer> res) {
        for (int num : cur) {
            if (num >= low && num <= high) {
                res.add(num);
            }
        }
    }

    private static List<Integer> helper(List<Integer> cur, int low, int high) {
        List<Integer> next = new LinkedList<>();
        for (int num : cur) {
            if (num == 0)
                continue;
            String str = String.valueOf(num);
            char c = str.charAt(str.length() - 1);
            long val1;
            long val2 = 0;
            if (c == '0') {
                val1 = Long.valueOf(str + "1");
            } else if (c == '9') {
                val1 = Long.valueOf(str + "8");
            } else {
                val1 = Long.valueOf(str + "" + ((char) ((int) c - 1)));
                val2 = Long.valueOf(str + "" + ((char) ((int) c + 1)));
            }
            // 溢出 Integer
            if (val1 <= Integer.MAX_VALUE) {
                next.add((int) val1);
            }
            if (val2 != 0 && val2 <= Integer.MAX_VALUE) {
                next.add((int) val2);
            }
        }
        return next;
    }

    public static void main(String[] args) {
        countSteppingNumbers(709852790, 1686392249);
        System.out.println(Integer.MAX_VALUE);
    }

}
