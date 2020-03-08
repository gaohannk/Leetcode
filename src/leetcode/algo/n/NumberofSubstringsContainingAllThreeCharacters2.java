package leetcode.algo.n;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
public class NumberofSubstringsContainingAllThreeCharacters2 {
    public int numberOfSubstrings(String s) {
        Queue<Pair> a = new LinkedList<>();
        Queue<Pair> b = new LinkedList<>();
        Queue<Pair> c = new LinkedList<>();

        int res = 0;
        int i = 0;
        while (i < s.length()) {
            int start = i;
            if (s.charAt(i) == 'a') {
                while (i < s.length() && s.charAt(i) == 'a') {
                    i++;
                }
                a.offer(new Pair(start, i - 1));
            } else if (s.charAt(i) == 'b') {
                while (i < s.length() && s.charAt(i) == 'b') {
                    i++;
                }
                b.offer(new Pair(start, i - 1));
            } else if (s.charAt(i) == 'c') {
                while (i < s.length() && s.charAt(i) == 'c') {
                    i++;
                }
                c.offer(new Pair(start, i - 1));
            }
            while (!a.isEmpty() && !b.isEmpty() && !c.isEmpty()) {
                int max = Math.max(Math.max(a.peek().start, b.peek().start), c.peek().start);
                int idx = getCharWithMinStart(a, b, c);
                res = addRes(s, a, b, c, res, max, idx);
            }
        }

        return res;
    }

    private int getCharWithMinStart(Queue<Pair> a, Queue<Pair> b, Queue<Pair> c) {
        int idx;
        if (a.peek().start < b.peek().start) {
            if (a.peek().start < c.peek().start) {
                idx = 1;
            } else {
                idx = 3;
            }
        } else {
            if (c.peek().start < b.peek().start) {
                idx = 3;
            } else {
                idx = 2;
            }
        }
        return idx;
    }

    private int addRes(String s, Queue<Pair> a, Queue<Pair> b, Queue<Pair> c, int res, int max, int idx) {
        if (idx == 1) {
            res += (a.peek().end - a.peek().start + 1) * (s.length() - max);
            a.poll();
        } else if (idx == 2) {
            res += (b.peek().end - b.peek().start + 1) * (s.length() - max);
            b.poll();
        } else if (idx == 3) {
            res += (c.peek().end - c.peek().start + 1) * (s.length() - max);
            c.poll();
        }
        return res;
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
