package leetcode;

/**
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 * <p>
 * For example:
 * <p>
 * Given "aacecaaa", return "aaacecaaa".
 * <p>
 * Given "abcd", return "dcbabcd".
 */
public class ShortestPalindrome {
    public static String shortestPalindrome(String s) {
        int nw = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (isPalindrome(s, i)) {
                nw = s.length() - 1 - i;
                break;
            }
        }
        StringBuilder r = new StringBuilder(s.substring(s.length()-nw , s.length()));
        return r.reverse().toString() + s;
    }

    public static boolean isPalindrome(String s, int n) {
        for (int i = 0; i <= n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(shortestPalindrome("abcd"));
    }
}
