package leetcode.v;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * <p>
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 */
public class ValidPalindromeII2
{

    public boolean validPalindrome(String s)
    {
        return helper(s, 0, s.length() - 1, false);
    }

    private boolean helper(String s, int i, int j, boolean jump)
    {
        if (i > j)
        {
            return true;
        }
        if (s.charAt(i) == s.charAt(j))
        {
            return helper(s, i + 1, j - 1, jump);
        }
        else if (jump)
        {
            return false;
        }
        else
        {
            return helper(s, i + 1, j, true) || helper(s, i, j - 1, true);
        }
    }

}
