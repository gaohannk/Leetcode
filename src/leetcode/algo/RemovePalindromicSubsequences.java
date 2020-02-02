package leetcode.algo;

public class RemovePalindromicSubsequences {
    public int removePalindromeSub(String s) {
        if (s.length() == 0)
            return 0;

        // check if s is palindromic
        boolean isPalindromic = true;
        int left = 0;
        int right = s.length() - 1;
        for (; left < right; left++, right--)
            if (s.charAt(left) != s.charAt(right)) {
                isPalindromic = false;
                break;
            }

        return isPalindromic ? 1 : 2;
    }
}
