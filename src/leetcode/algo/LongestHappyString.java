package leetcode.algo;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A string is called happy if it does not have any of the strings 'aaa', 'bbb' or 'ccc' as a substring.
 *
 * Given three integers a, b and c, return any string s, which satisfies following conditions:
 *
 * s is happy and longest possible.
 * s contains at most a occurrences of the letter 'a', at most b occurrences of the letter 'b' and at most c occurrences of the letter 'c'.
 * s will only contain 'a', 'b' and 'c' letters.
 * If there is no such string s return the empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: a = 1, b = 1, c = 7
 * Output: "ccaccbcc"
 * Explanation: "ccbccacc" would also be a correct answer.
 * Example 2:
 *
 * Input: a = 2, b = 2, c = 1
 * Output: "aabbc"
 * Example 3:
 *
 * Input: a = 7, b = 1, c = 0
 * Output: "aabaa"
 * Explanation: It's the only correct answer in this case.
 *
 *
 * Constraints:
 *
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 */
public class LongestHappyString {
    public static String longestDiverseString(int a, int b, int c) {
        Queue<Pair> queue = new PriorityQueue<>((o1, o2) -> o1.count < o2.count ? 1 : o1.count == o2.count ? 0 : -1);
        queue.add(new Pair(a, 'a'));
        queue.add(new Pair(b, 'b'));
        queue.add(new Pair(c, 'c'));
        StringBuilder res = new StringBuilder();
        char last = ' ';
        while (true) {
            boolean add = false;
            if (queue.isEmpty()) {
                break;
            }
            Pair cur = queue.poll();
            if(cur.c == last){
                Pair next = queue.poll();
                res.append(next.c);
                res.append(next.c);
                next-=2;
                queue.offer(next);
            }
            if (cur.count > 2) {
                res.append(cur.c);
                res.append(cur.c);
                cur.count -= 2;
                add = true;
            } else if (cur.count == 2) {
                res.append(cur.c);
                res.append(cur.c);
            } else {
                res.append(cur.c);
            }
            if (queue.isEmpty()) {
                break;
            }

            Pair next = queue.poll();
            if (next.count > 1) {
                res.append(next.c);
                next.count--;
                queue.offer(next);
            }else{
                res.append(next.c);
            }
            if(add) {
                queue.offer(cur);
            }
            last = next.c;
        }
        return res.toString();
    }

    static class Pair {
        int count;
        char c;

        public Pair(int count, char c) {
            this.count = count;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestDiverseString(1, 2, 3));
    }
}
