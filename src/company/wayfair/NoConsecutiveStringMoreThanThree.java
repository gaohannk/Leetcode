package company.wayfair;

/**
 * Input eedaaad
 * Output eedaad
 * <p>
 * xxxttxxx
 * xxttxx
 */
public class NoConsecutiveStringMoreThanThree {

    public static String solution(String input) {
        if (input.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char cur = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            while (i < input.length() && cur == input.charAt(i)) {
                i++;
                count++;
            }
            // break due to new char
            if (i < input.length()) {
                if (count >= 2) {
                    sb.append(cur + "" + cur);
                } else {
                    sb.append(cur);
                }
                count = 1;
                cur = input.charAt(i);
            }
        }
        // break due to the end for current char
        if (count >= 2) {
            sb.append(cur + "" + cur);
        } else {
            sb.append(cur);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] inputs = {"eedaaad", "xxxttxxx", "x", "xx", "xxx", "xxxx", "xdxxxx", "xdx", "xdxxxtt"};
        for (String input : inputs) {
            System.out.println(solution(input));
        }
    }
}
