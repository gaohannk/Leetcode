package company.weride;

import java.util.Scanner;

public class RegexMatch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String regex = sc.nextLine();

        boolean res = isMatch(input, regex);
        System.out.println(res);
    }


    public static boolean isMatch(String s, String re) {
        // length 0
        if (re.length() == 0)
            return s.length() == 0;

        // length 1
        if (re.length() == 1) {
            if ((s.length() == 1) && (re.charAt(0) == s.charAt(0) || re.charAt(0) == '.')) {
                return true;
            } else {
                return false;
            }
        }

        // next char is not '*': must match current character
        if (re.charAt(1) != '*') {
            if (s.length() < 1)
                return false;
            else
                return (s.charAt(0) == re.charAt(0) || re.charAt(0) == '.') && isMatch(s.substring(1), re.substring(1));
        }

        // next char is *
        while (s.length() > 0 && (re.charAt(0) == s.charAt(0) || re.charAt(0) == '.')) {
            if (isMatch(s, re.substring(2)))
                return true;
            s = s.substring(1);
        }
        return isMatch(s, re.substring(2));
    }

}
