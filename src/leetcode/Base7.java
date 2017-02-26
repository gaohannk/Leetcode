package leetcode;

/**
 * Given an integer, return its base 7 string representation.
 * <p>
 * Example 1:
 * Input: 100
 * Output: "202"
 * Example 2:
 * Input: -7
 * Output: "-10"
 */
public class Base7 {
    public String convertToBase7(int num) {
        String res = "";
        boolean flag = false;
        if (num < 0) {
            flag = true;
            num = -num;
        }
        while (num >= 7) {
            int residue = num - 7 * (num / 7);
            num = num / 7;
            res = residue + res;
        }
        res = num + res;
        if (flag)
            res = "-" + res;
        return res;
    }
}
