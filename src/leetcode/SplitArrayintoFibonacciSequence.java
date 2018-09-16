package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S of digits, such as S = "123456579", we can split it into a Fibonacci-like sequence [123, 456, 579].
 * <p>
 * Formally, a Fibonacci-like sequence is a list F of non-negative integers such that:
 * <p>
 * 0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer type);
 * F.length >= 3;
 * and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.
 * Also, note that when splitting the string into pieces, each piece must not have extra leading zeroes, except if the piece is the number 0 itself.
 * <p>
 * Return any Fibonacci-like sequence split from S, or return [] if it cannot be done.
 * <p>
 * Example 1:
 * <p>
 * Input: "123456579"
 * Output: [123,456,579]
 * Example 2:
 * <p>
 * Input: "11235813"
 * Output: [1,1,2,3,5,8,13]
 * Example 3:
 * <p>
 * Input: "112358130"
 * Output: []
 * Explanation: The task is impossible.
 * Example 4:
 * <p>
 * Input: "0123"
 * Output: []
 * Explanation: Leading zeroes are not allowed, so "01", "2", "3" is not valid.
 * Example 5:
 * <p>
 * Input: "1101111"
 * Output: [110, 1, 111]
 * Explanation: The output [11, 0, 11, 11] would also be accepted.
 * Note:
 * <p>
 * 1 <= S.length <= 200
 * S contains only digits.
 */
public class SplitArrayintoFibonacciSequence {
    public List<Integer> splitIntoFibonacci(String S) {
        int N = S.length();
        for (int i = 0; i < Math.min(10, N); i++) {
            if (S.charAt(0) == '0' && i > 0)
                break;
            long a = Long.valueOf(S.substring(0, i + 1));
            if (a >= Integer.MAX_VALUE)
                break;

            search:
            for (int j = i + 1; j < Math.min(i + 10, N); j++) {
                if (S.charAt(i + 1) == '0' && j > i + 1)
                    break;
                long b = Long.valueOf(S.substring(i + 1, j + 1));
                if (b >= Integer.MAX_VALUE)
                    break;

                List<Integer> fib = new ArrayList();
                fib.add((int) a);
                fib.add((int) b);

                int k = j + 1;
                while (k < N) {
                    int nxt = fib.get(fib.size() - 2) + fib.get(fib.size() - 1);
                    String nxtS = String.valueOf(nxt);

                    if (nxt <= Integer.MAX_VALUE && S.substring(k).startsWith(nxtS)) {
                        k += nxtS.length();
                        fib.add(nxt);
                    } else
                        continue search;
                }
                if (fib.size() >= 3)
                    return fib;
            }
        }

        return new ArrayList<Integer>();
    }
}
