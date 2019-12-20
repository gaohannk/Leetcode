package leetcode.algo.r;

import java.util.Arrays;

// TODO: Wrong solution
public class ReplacetheSubstringforBalancedString {
    public static int balancedString(String s) {
        int len = s.length();
        int count[] = new int[4];
        Arrays.fill(count, 0);
        int i = 0, j = len - 1;
        char left = s.charAt(len - 1), right = s.charAt(0);
        while (i < s.length()) {
            char c = s.charAt(i);
            switch (c) {
                case 'Q':
                    count[0]++;
                    break;
                case 'W':
                    count[1]++;
                    break;
                case 'E':
                    count[2]++;
                    break;
                case 'R':
                    count[3]++;
                    break;
            }
            if (count[0] > len / 4 || count[1] > len / 4 || count[2] > len / 4 || count[3] > len / 4) {
                left = c;
                break;
            }
            i++;
        }
        Arrays.fill(count, 0);
        while (j >= 0) {
            char c = s.charAt(j);
            switch (c) {
                case 'Q':
                    count[0]++;
                    break;
                case 'W':
                    count[1]++;
                    break;
                case 'E':
                    count[2]++;
                    break;
                case 'R':
                    count[3]++;
                    break;
            }
            if (count[0] > len / 4 || count[1] > len / 4 || count[2] > len / 4 || count[3] > len / 4) {
                right = c;
                break;
            }
            j--;
        }
        if (j < i) {
            if (left == right ) {
                if(j == len-1 && i ==0 ){
                    return len/4;
                }
                return j-i + +1+  len/4;
            } else {
                return 0;
            }
        }
        return left == right ? j - i + 1 + len / 4 : j - i + 1;
    }

    public static void main(String[] args) {
        System.out.println(balancedString("EQQQQQQQQQQQ"));
        System.out.println(balancedString("QQWE"));
        System.out.println(balancedString("QQQE"));
        System.out.println(balancedString("QWER"));
        System.out.println(balancedString("QWEQ"));
        System.out.println(balancedString("QQQWEQQQ"));
        System.out.println(balancedString("QQQQQQQQ"));
        System.out.println(balancedString("QQQQQWEQQQQQ"));
        System.out.println(balancedString("QQQQQEQQQQQQ"));

    }
}
