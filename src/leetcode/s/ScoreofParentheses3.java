package leetcode.s;

/**
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
 * <p>
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: 1
 * Example 2:
 * <p>
 * Input: "(())"
 * Output: 2
 * Example 3:
 * <p>
 * Input: "()()"
 * Output: 2
 * Example 4:
 * <p>
 * Input: "(()(()))"
 * Output: 6
 * <p>
 * <p>
 * Note:
 * <p>
 * S is a balanced parentheses string, containing only ( and ).
 * 2 <= S.length <= 50
 */
//Divide and Conquer
public class ScoreofParentheses3 {
    public static int scoreOfParentheses(String S) {
        return helper(S, 0, S.length());
    }

    private static int helper(String s, int start, int end) {
        //Score of balanced string S[i:j]
        int ans = 0, bal = 0;

        for (int i = start; i < end; i++) {
            if (s.charAt(i) == '(') {
                bal += 1;
            } else {
                bal -= 1;
            }
            if (bal == 0) {
                if (i - start == 1)
                    ans++;
                else
                    ans += 2 * helper(s, start + 1, i);
                start = i + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        scoreOfParentheses("((()()))(())");
    }
}
