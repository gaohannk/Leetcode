package leetcode;

/**
 * Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, the variable x and its coefficient.
 * <p>
 * If there is no solution for the equation, return "No solution".
 * <p>
 * If there are infinite solutions for the equation, return "Infinite solutions".
 * <p>
 * If there is exactly one solution for the equation, we ensure that the value of x is an integer.
 * <p>
 * Example 1:
 * Input: "x+5-3+x=6+x-2"
 * Output: "x=2"
 * Example 2:
 * Input: "x=x"
 * Output: "Infinite solutions"
 * Example 3:
 * Input: "2x=x"
 * Output: "x=0"
 * Example 4:
 * Input: "2x+3x-6x=x+2"
 * Output: "x=-1"
 * Example 5:
 * Input: "x=x+2"
 * Output: "No solution"
 */
public class SolvetheEquation {

    public static String solveEquation(String equation) {
        String left = equation.split("=")[0];
        String right = equation.split("=")[1];
        if (left.charAt(0) == '+' || left.charAt(0) == '-')
            left = "0" + left;
        if (right.charAt(0) == '+' || right.charAt(0) == '-')
            right = "0" + right;
        int coeff_left[] = processString(left);
        int coeff_right[] = processString(right);

        if (coeff_left[0] == coeff_right[0] && coeff_left[1] == coeff_right[1])
            return "Infinite solutions";
        if (coeff_left[0] == coeff_right[0] && coeff_left[1] != coeff_right[1])
            return "No solution";
        return "x=" + (coeff_right[1] - coeff_left[1]) / (coeff_left[0] - coeff_right[1]);
    }

    public static int[] processString(String str) {
        int i = 0;
        int sign = 1;
        int[] res = new int[2];
        while (i < str.length()) {
            String num = "";
            while (i < str.length() && Character.isDigit(str.charAt(i))) {
                num += str.charAt(i);
                i++;
            }
            int numvalue = num == "" ? 1 : Integer.parseInt(num);
            if (i >= str.length()) {
                res[1] += sign * numvalue;
                break;
            }
            if (str.charAt(i) == 'x') {
                res[0] += sign * numvalue;
                if (i + 1 < str.length()) {
                    sign = str.charAt(i + 1) == '+' ? 1 : -1;
                }
                i += 2;
            } else if (str.charAt(i) == '+') {
                res[1] += sign * numvalue;
                sign = 1;
                i++;
            } else {
                res[1] += sign * numvalue;
                sign = -1;
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solveEquation("x=x+2"));
    }
}
