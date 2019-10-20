package leetcode.k;

/**
 * Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.  The guards have gone and will come back in H hours.
 * <p>
 * Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of bananas, and eats K bananas from that pile.  If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.
 * <p>
 * Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.
 * <p>
 * Return the minimum integer K such that she can eat all the bananas within H hours.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: piles = [3,6,7,11], H = 8
 * Output: 4
 * Example 2:
 * <p>
 * Input: piles = [30,11,23,4,20], H = 5
 * Output: 30
 * Example 3:
 * <p>
 * Input: piles = [30,11,23,4,20], H = 6
 * Output: 23
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        // At least eat on banana
        int low = 1, high = 0, mid = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (high - low > 0) {
            mid = (low + high) / 2;
            if (canEat(mid, piles, H)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    private boolean canEat(int mid, int[] piles, int H) {
        int total = 0;
        for (int pile : piles) {
            total += (pile - 1) / mid + 1;
        }
        return total <= H;
    }
}
