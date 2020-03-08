package leetcode.algo.n;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a string s consisting only of characters a, b and c.
 *
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
 * Example 2:
 *
 * Input: s = "aaacb"
 * Output: 3
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
 * Example 3:
 *
 * Input: s = "abc"
 * Output: 1
 *
 *
 * Constraints:
 *
 * 3 <= s.length <= 5 x 10^4
 * s only consists of a, b or c characters.
 */
public class NumberofSubstringsContainingAllThreeCharacters4 {
    public int numberOfSubstrings(String s) {
        Queue<Pair>[] queues = new Queue[3];
        for (int i = 0; i < queues.length; i++) {
            queues[i] = new LinkedList<>();
        }

        int res = 0;
        int i = 1;
        while (i < s.length()) {
            int start = i;
            while (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                i++;
            }
            queues[s.charAt(i - 1) - 'a'].offer(new Pair(start, i - 1));
            i++;
        }
        queues[s.charAt(s.length() - 1) - 'a'].offer(new Pair(s.length() -1, s.length() - 1));

        while (allQueueNotEmpty(queues)) {
            int max = 0, min = Integer.MAX_VALUE;
            int idx = 0;
            for (i = 0; i < queues.length; i++) {
                if (min > queues[i].peek().start) {
                    min = queues[i].peek().start;
                    idx = i;
                }
                max = Math.max(max, queues[i].peek().start);
            }
            res += (queues[idx].peek().end - queues[idx].peek().start + 1) * (s.length() - max);
            queues[idx].poll();
        }

        return res;
    }

    private boolean allQueueNotEmpty(Queue<Pair>[] queues) {
        for (Queue<Pair> q : queues) {
            if (q.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
