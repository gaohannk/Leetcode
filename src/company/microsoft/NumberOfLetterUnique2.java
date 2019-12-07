package company.microsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * least number of letters to be removed so that occurrences of each letter is unique -> example: ‍‍‍‌‍‌‍‍‌‌‍‍‌‌‍‌aabbbbccd -> 2 (bbbbccd / abbbbcc / aabbbbc / aabbbbd)
 */
public class NumberOfLetterUnique2 {
    public static int remove(String letters) {
        int[] letterToCount = new int[128];
        int maxCnt = 0;
        for (char letter : letters.toCharArray()) {
            maxCnt = Math.max(maxCnt, ++letterToCount[letter - 'a']);
        }
        int[] countSum = new int[maxCnt + 1];
        for (int i = 0; i < 128; i++) {
            countSum[letterToCount[i]]++;
        }
        int res = 0;
        List<Integer> availableSlots = new ArrayList<>();
        for (int i = 1; i <= maxCnt; i++) {
            if (countSum[i] == 0)
                availableSlots.add(i);
        }
        int slotIndex = availableSlots.size() - 1;
        // starting from the maxCnt
        for (int cnt = maxCnt; cnt > 0; cnt--) {
            while (countSum[cnt] > 1) {
                if (slotIndex >= 0) {
                    res += cnt - availableSlots.get(slotIndex--);
                } else {
                    res += cnt;
                }
                countSum[cnt]--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[0];
        System.out.println(remove("abbccddsssseeeefffd"));
    }
}
