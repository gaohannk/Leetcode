package company.microsoft.oa;

/**
 * Given a string S consisting of N letters a and b. In one move you can replace one letter by the other (a by b or b by a).
 *
 * Write a function solution that given such a string S, returns the minimum number of moves required to obtain a string containing no instances of three identical consecutive letters.
 *
 * Example 1:
 *
 * Input: "baaaaa"
 * Output: 1
 * Explanation: The string without three identical consecutive letters which can be obtained is one move is "baabaa".
 * Example 2:
 *
 * Input: "baaabbaabbba"
 * Output: 2
 * Explanation: There are four valid strings obtainable in two moves, for example "bbaabbaabbaa".
 * Example 3:
 *
 * Input: "baabab"
 * Ouput: 0
 * Assumptions:
 *
 * N is an integer within the range [0, ..200,000];
 * string S consists of only characteres a and b.
 */
public class MinMovestoObtainStringWithoutThreeIdenticalConsecutiveLetters {
    public static int solution(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            while(i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
            res += count / 3;
        }
        return res;
    }

    public static void main(String[] args) {
        test(solution("baaaaa"), 1);
        test(solution("baaaaaa"), 2);
        test(solution("baaaab"), 1);
        test(solution("baaabbaabbba"), 2);
        test(solution("baabab"), 0);
        test(solution("bbaabbaabbabab"), 0);
    }

    private static void test(int actual, int expected) {
        if (actual == expected) {
            System.out.println("PASSED!");
        } else {
            System.out.println(String.format("FAILED! Expected %d, but got: %d", expected, actual));
        }
    }
}
