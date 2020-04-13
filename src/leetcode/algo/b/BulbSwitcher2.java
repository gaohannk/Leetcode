package leetcode.algo.b;

import java.util.Arrays;

/* There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
 * Example:
 * Given n = 3.
 * At first, the three bulbs are [off, off, off].
 * After first round, the three bulbs are [on, on, on].
 * After second round, the three bulbs are [on, off, on].
 * After third round, the three bulbs are [on, off, off].
 * So you should return 1, because there is only one bulb is on.
 */
// TLE brute force
public class BulbSwitcher2 {
    public int bulbSwitch(int n) {
        if (n == 1) {
            return 1;
        }
        int[] bulb = new int[n + 1];
        Arrays.fill(bulb, 1);

        int base = 1;
        while (base <= n) {
            int id = base;
            int count = 1;
            while (id < n) {
                bulb[id] = -bulb[id];
                count++;
                id = base * count;
            }
            base++;
        }
        System.out.println(Arrays.toString(bulb));
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = bulb[i] == 1 ? res + 1 : res;
        }
        return res;
    }
}
