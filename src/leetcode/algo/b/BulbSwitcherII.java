package leetcode.algo.b;

/**
 * There is a room with n lights which are turned on initially and 4 buttons on the wall. After performing exactly m unknown operations towards buttons, you need to return how many different kinds of status of the n lights could be.
 *
 * Suppose n lights are labeled as number [1, 2, 3 ..., n], function of these 4 buttons are given below:
 *
 * Flip all the lights.
 * Flip lights with even numbers.
 * Flip lights with odd numbers.
 * Flip lights with (3k + 1) numbers, k = 0, 1, 2, ...
 *
 *
 * Example 1:
 *
 * Input: n = 1, m = 1.
 * Output: 2
 * Explanation: Status can be: [on], [off]
 *
 *
 * Example 2:
 *
 * Input: n = 2, m = 1.
 * Output: 3
 * Explanation: Status can be: [on, off], [off, on], [off, off]
 *
 *
 * Example 3:
 *
 * Input: n = 3, m = 1.
 * Output: 4
 * Explanation: Status can be: [off, on, off], [on, off, on], [off, off, off], [off, on, on].
 */

/**
 * Let's add another switch, switch 0, the identity switch (switch 0 does nothing).
 * l1: f(0a) = f(a)
 *
 * First, note that flipping is commutative: order does not matter.
 * l2: f(ab) = f(ba)
 *
 * second, each function is an inverse of itself:
 * l3: f(aa) = f(0)
 *
 * finally, note that there flipping odds and evens is the same as flipping all:
 * l4: f(23) = f(1)
 * f(12) = f(3)
 * f(13) = f(2)
 *
 * Now we can reduce any sequence to something much simpler.
 * take a sequence like:
 * 14342
 * by lemma 2 we can re-order:
 * 12344
 * using l4:
 * 1144
 * then by l3:
 * 00
 * which is just the starting position.
 *
 * It turns out that we only care then if there is an even or odd number of each flip. The total enumeration of states is:
 * 0
 * 1
 * 2
 * 3
 * 4
 * 12
 * 13
 * 14
 * 23
 * 24
 * 34
 * 123
 * 124
 * 134
 * 234
 * 1234
 *
 * 16 states... but wait, using lemma 4, some of these are the same (eg 134 = 24). Removing the redundancies from the list above:
 * 0
 * 1
 * 2
 * 3
 * 4
 * 14
 * 24
 * 34
 *
 * we get 8 states.
 * So for a sufficiently high m (turns out its >= 3), we get:
 * flipLights(0) = 1;
 * flipLights(1) = 4
 * flipLights(2+) = 8
 */
public class BulbSwitcherII {
    public int flipLights(int n, int m) {
        //Corner, No bulb or No operation
        if (n == 0 || m == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        if (n == 2 && m == 1) {
            return 3;
        }
        if (n == 2) {
            return 4;
        }
        if (m == 1) {
            return 4;
        }
        if (m == 2) {
            return 7;
        }
        if (m >= 3) {
            return 8;
        }
        return 8;
    }
}
